package com.pal.intern.service;

import com.pal.intern.domain.Report;
import com.pal.intern.domain.ReportCreation;
import java.util.Map;
import java.util.Optional;

public interface ReportService {

    public int createReport(String reportSubject, int reportType, String reportDataEtc, int userId);

    public int saveReport(ReportCreation reportCreation, int userId);

    public Optional<Report> getReportById(int reportId);

    /**
     *
     * @param reportId
     * @return Map report: report with id given tasks : list tasks with report
     * id given recipients : list recipients with id given
     *
     */
    public Map<String, Object> getReportByIdWithRecipientAndTasks(int reportId);

    /**
     *
     * @param userId user id
     * @param reportType report status (1:save, 2: send)
     * @param page page number (begin at 1)
     * @param pageSize number of records in one page
     * @return Map
     */
    public Map<String, Object> getReportByUserIdAndStatusWithPaging(int userId, int reportType, int page, int pageSize);
    
    public int updateReportByReportId(Report report);
    
    public int deleteReportByReportId(int reportId);
}
