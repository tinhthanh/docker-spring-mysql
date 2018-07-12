package com.pal.intern.repository;

import com.pal.intern.domain.Report;
import java.util.Map;
import java.util.Optional;

public interface ReportRepository {

    public int createReport(String reportSubject, int reportType, String reportDataEtc, int userId);

    public Optional<Report> getReportById(int reportId);

    /**
     *
     * @param userId user id
     * @param reportType report status (1:save, 2: send)
     * @param page page number (begin at 1)
     * @param pageSize number of records in one page
     * @return Map
     */
    public Map<String, Object> getReportByUserIdAndStatusWithPaging(int userId, int reportType, int page, int pageSize);

    public boolean isReportOwner(int reportId, int userId);

    public int updateReportByAttr(String key, Object value, int reportID);
    
    public int updateReportByReportId(Report report);
    
    public int deleteReportByReportId(int reportId);
}
