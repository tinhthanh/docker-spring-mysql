package com.pal.intern.domain;

import java.time.LocalDateTime;

public class Report {

    private int reportId;
    private String reportSubject;
    private int reportType;
    private String reportDataEtc;
    private LocalDateTime actionTime;

    public Report() {
    }

    public Report(int reportId, String reportSubject, int reportType, String reportDataEtc, LocalDateTime actionTime) {
        this.reportId = reportId;
        this.reportSubject = reportSubject;
        this.reportType = reportType;
        this.reportDataEtc = reportDataEtc;
        this.actionTime = actionTime;
    }

    public int getReportId() {
        return reportId;
    }

    public String getReportSubject() {
        return reportSubject;
    }

    public int getReportType() {
        return reportType;
    }

    public String getReportDataEtc() {
        return reportDataEtc;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public void setReportSubject(String reportSubject) {
        this.reportSubject = reportSubject;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public void setReportDataEtc(String reportDataEtc) {
        this.reportDataEtc = reportDataEtc;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return "Report{" + "reportId=" + reportId + ", reportSubject=" + reportSubject + ", reportType=" + reportType + ", reportDataEtc=" + reportDataEtc + ", actionTime=" + actionTime + '}';
    }

}
