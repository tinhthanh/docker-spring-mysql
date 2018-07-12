package com.pal.intern.config.jwt;

import com.pal.intern.config.app.ConfigVariable;
import com.pal.intern.config.app.ParamConfig;
import com.pal.intern.domain.User;
import com.pal.intern.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.TextCodec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImp implements JwtService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @Autowired
    private ParamConfig paramConfig;

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    public static final String AUDIENCE_UNKNOWN = "unknown";
    public static final String AUDIENCE_WEB = "web";
    public static final String AUDIENCE_MOBILE = "mobile";
    public static final String AUDIENCE_TABLET = "tablet";

    @Override
    public String getUserNameFromToKen(String token) {
        String userName;
        try {
            Claims claims = this.getAllClaimsFromToken(token);
            userName = claims.getSubject();
        } catch (Exception e) {
            userName = null;
            LOGGER.error("Error when call method getUserNameFromToKen() with param " + token, e);
        }
        return userName;
    }

    @Override
    public LocalDateTime getIssuedDate(String token) {
        LocalDateTime issueAt = null;
        try {
            Claims claims = this.getAllClaimsFromToken(token);
            issueAt = LocalDateTime.ofInstant(claims.getIssuedAt().toInstant(), ZoneId.systemDefault());
        } catch (Exception e) {
            LOGGER.error("Error when call method getIssuedDate() with param " + token, e);
        }
        return issueAt;
    }

    @Override
    public String getToken(HttpServletRequest request) {

        /**
         * get token from from request header
         */
        String authRequest = request.getHeader(this.paramConfig.getParamConfig(ConfigVariable.JWT_REQUEST_HEADER));
        if (authRequest != null) {
            if (authRequest.startsWith(this.paramConfig.getParamConfig(ConfigVariable.JWT_PREFIX))) {
                /**
                 * subString token with (BEAR) length + space " "
                 */
                return authRequest.substring(this.paramConfig.getParamConfig(ConfigVariable.JWT_PREFIX).length() + 1);
            }
        }

        /**
         * get token from AUTH cookie
         */
        Cookie cookie = this.getCookieByCookieName(this.paramConfig.getParamConfig(ConfigVariable.JWT_COOKIE_NAME), request);

        if (cookie != null) {
            LOGGER.info(cookie.toString());
            return cookie.getValue();
        }

        return null;

    }

    public Cookie getCookieByCookieName(String cookieName, HttpServletRequest request) {
        if (request.getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }
        }
        return null;

    }

    @Override
    public Claims getAllClaimsFromToken(String token) {
        LOGGER.info(token);
        Claims claims;
        try {
            String jwtSerect = this.paramConfig.getJwtSecret();
            LOGGER.info(jwtSerect);
            claims = (Claims) Jwts.parser().setSigningKey(TextCodec.BASE64.decode(jwtSerect)).parse(token).getBody();
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            LOGGER.error("Error when call method with param " + token, e);
            claims = null;
        }
        return claims;
    }

    @Override
    public boolean validateToken(String authToken, UserDetails userDetails) {
        /**
         * check user name is exist on system user was login and store in
         * UserDetails
         */
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());
        LOGGER.info(user.get().toString());
        if (!user.isPresent()) {
            return false;
        }
        String userNameFromToken = this.getUserNameFromToKen(authToken);
        LOGGER.info("[username form token] " + userNameFromToken);
        LocalDateTime issueDate = this.getIssuedDate(authToken);
        LOGGER.info("[issue date of token] " + issueDate.toString());
        LocalDateTime userLastPasswordResetDate = user.get().getLastPasswordchange();
        LOGGER.info("[last password reset date of user]" + userLastPasswordResetDate.toString());
        return (userNameFromToken != null && user.get().getUserName().equals(userNameFromToken) && (!isCreatedBeforeLastPasswordReset(issueDate, userLastPasswordResetDate)));
    }

    /**
     * check issue date of token is before last password reset date of user
     *
     * @param issueDate issue date of token
     * @param userLastPasswordResetDate last password reset date of user
     * @return boolean
     */
    private boolean isCreatedBeforeLastPasswordReset(LocalDateTime issueDate, LocalDateTime userLastPasswordResetDate) {
        return issueDate.isBefore(userLastPasswordResetDate);
    }

    @Override
    public String generateToken(String username, Device device) {
        String token = null;
        try {
            Date dateIssued = new Date();
            token = Jwts.builder().setSubject(username)
                    .setAudience(this.getAudience(device))
                    .setIssuedAt(dateIssued)
                    .setExpiration(this.generateExpirationDate(device, dateIssued))
                    .signWith(SIGNATURE_ALGORITHM, TextCodec.BASE64.decode(this.paramConfig.getJwtSecret()))
                    .compact();
        } catch (Exception e) {
            LOGGER.error("Error when call method generateToken() with param " + Arrays.asList(username,device), e);
        }

        return token;
    }

    private Date generateExpirationDate(Device device, Date dateIssued) {
        long expiresIn = 0;
        try {
            /**
             * get expire time by device
             */
            expiresIn = this.getExpiredIn(device);

            LOGGER.info(expiresIn + " [expire time in second]");
        } catch (Exception e) {
            LOGGER.error("Error when call method generateExpirationDate() with param " + Arrays.asList(device,dateIssued), e);
        }
        return new Date(dateIssued.getTime() + (expiresIn * 1000));

    }

    private String getAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }

        return audience;

    }

    @Override
    public long getExpiredIn(Device device) {
        long timeExpiredIn = 0;

        if (device.isNormal()) {
            timeExpiredIn = Long.valueOf(this.paramConfig.getParamConfig(ConfigVariable.JWT_EXPIRATION_NORMAL));
        } else {
            if (device.isTablet() || device.isMobile()) {
                timeExpiredIn = Long.valueOf(this.paramConfig.getParamConfig(ConfigVariable.JWT_EXPIRATION_MOBILE));
            }
        }
        return timeExpiredIn;
    }

    /**
     * create authentication cookie
     *
     * @param jwt JSON web token
     * @param expiresIn cookie expiration time
     * @return authentication cookie
     */
    @Override
    public Cookie createAuthCookie(String jwt, int expiresIn) {
        Cookie authCookie = new Cookie(this.paramConfig.getParamConfig(ConfigVariable.JWT_COOKIE_NAME), jwt);
        authCookie.setPath("/");
        authCookie.setHttpOnly(true);
        authCookie.setMaxAge(expiresIn);
        return authCookie;

    }

}
