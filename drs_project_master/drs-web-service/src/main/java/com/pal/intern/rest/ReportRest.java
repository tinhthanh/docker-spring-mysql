package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.config.security.AuthenticationFacade;
import com.pal.intern.domain.Report;
import com.pal.intern.domain.ReportCreation;
import com.pal.intern.domain.User;
import com.pal.intern.service.ReportService;
import com.pal.intern.service.UserService;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reports")
public class ReportRest {

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createReport(@RequestBody ReportCreation reportCreation, HttpServletRequest httpServletRequest) {
        Authentication authentication = authenticationFacade.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());
        int reportId = this.reportService.saveReport(reportCreation, user.get().getUserId());
        LOGGER.info(reportId + "[report id after save]");
        if (reportId == -1) {
            HttpStatus httpStatus = HttpStatus.CONFLICT;
            ApiError apiError = new ApiError(httpStatus, httpStatus.value(), ApiError.getFullURL(httpServletRequest), Arrays.asList("create report failed"));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return ResponseEntity.ok(this.reportService.getReportByIdWithRecipientAndTasks(reportId));
    }

    @RequestMapping(value = "/{reportId}", method = RequestMethod.GET)
//    @PreAuthorize(value = "isReportOwner(#reportId)||hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getReportWithId(@PathVariable("reportId") int reportId) {
        return ResponseEntity.ok(this.reportService.getReportByIdWithRecipientAndTasks(reportId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getReportByUserIdAndStatusWithPaging(
            @RequestParam(value = "page", required = true, defaultValue = "1") int page,
            @RequestParam(value = "pageSize", required = true, defaultValue = "25") int pageSize,
            @RequestParam(value = "userId", required = false, defaultValue = "0") int userId,
            @RequestParam(value = "reportType") int reportType
    ) {
        if (userId == 0) {
            Authentication authentication = authenticationFacade.getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<User> user = this.userService.getUserByUserName(userDetails.getUsername());
            if (!user.isPresent()) {
                throw new AccessDeniedException("invalid token");
            }
            userId = user.get().getUserId();
        }

        Map<String, Object> result = this.reportService.getReportByUserIdAndStatusWithPaging(userId, reportType, page, pageSize);

        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize(value = "isReportOwner(#report.reportId)")
    public ResponseEntity<?> updateReportById(@RequestBody Report report, HttpServletRequest request) {
        int rs = this.reportService.updateReportByReportId(report);
        LOGGER.info("[report had been updated]");
        if (rs <= 0) {
            ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("Update Failed"));
            return new ResponseEntity<>(apiError, apiError.getStatus());

        }
        Report reportQuery = reportService.getReportById(report.getReportId()).get();
        return ResponseEntity.ok(reportQuery);
    }

    @RequestMapping(value = "/{reportId}", method = RequestMethod.DELETE)
    @PreAuthorize(value = "isReportOwner(#reportId)")
    public ResponseEntity<?> deleteReportById(@PathVariable("reportId") int reportId, HttpServletRequest request) {
        int rs = this.reportService.deleteReportByReportId(reportId);
        LOGGER.info("[report had been delete]");
        if (rs <= 0) {
            ApiError apiError = new ApiError(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), ApiError.getFullURL(request), Arrays.asList("Delete Failed"));
            return new ResponseEntity<>(apiError, apiError.getStatus());

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
