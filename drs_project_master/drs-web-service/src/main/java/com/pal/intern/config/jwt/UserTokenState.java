package com.pal.intern.config.jwt;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class UserTokenState {

    private String accessToken;
    private String tokenType;
    private String generateTime;
    private String expireAfter;

    public UserTokenState() {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS Z");
        this.generateTime = ZonedDateTime.now().format(FORMATTER);

    }

    public UserTokenState(String accessToken, String tokenType, String generateTime, String expireAfter) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.generateTime = generateTime;
        this.expireAfter = expireAfter;
    }

   

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setExpireAfter(String expireAfter) {
        this.expireAfter = expireAfter;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpireIn(long expireIn) {
        this.expireAfter = expireIn + " seconds";

    }

    public String getGenerateTime() {
        return generateTime;
    }

    public String getExpireAfter() {
        return expireAfter;
    }

    public void setGenerateTime(String generateTime) {
        this.generateTime = generateTime;
    }

    @Override
    public String toString() {
        return "UserTokenState{" + "accessToken=" + accessToken + ", tokenType=" + tokenType + ", generateTime=" + generateTime + ", expireAfter=" + expireAfter + '}';
    }

}
