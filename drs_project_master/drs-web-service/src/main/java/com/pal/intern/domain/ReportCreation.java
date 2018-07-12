package com.pal.intern.domain;

import java.util.List;

public class ReportCreation {

    private String reportSubject;
    private int reportType;
    private String dataEtc;
    private List<TaskCreation> tasks;
    private List<ReportRecipient> recipients;
    private String rawTaskInfo;

    public ReportCreation() {
    }

    public ReportCreation(String reportSubject, int reportType, String dataEtc, List<TaskCreation> tasks, List<ReportRecipient> recipients, String rawTaskInfo) {
        this.reportSubject = reportSubject;
        this.reportType = reportType;
        this.dataEtc = dataEtc;
        this.tasks = tasks;
        this.recipients = recipients;
        this.rawTaskInfo = rawTaskInfo;
    }

    public String getReportSubject() {
        return reportSubject;
    }

    public int getReportType() {
        return reportType;
    }

    public String getDataEtc() {
        return dataEtc;
    }

    public List<TaskCreation> getTasks() {
        return tasks;
    }

    public List<ReportRecipient> getRecipients() {
        return recipients;
    }

    public String getRawTaskInfo() {
        return rawTaskInfo;
    }

    public void setReportSubject(String reportSubject) {
        this.reportSubject = reportSubject;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public void setDataEtc(String dataEtc) {
        this.dataEtc = dataEtc;
    }

    public void setTasks(List<TaskCreation> tasks) {
        this.tasks = tasks;
    }

    public void setRecipients(List<ReportRecipient> recipients) {
        this.recipients = recipients;
    }

    public void setRawTaskInfo(String rawTaskInfo) {
        this.rawTaskInfo = rawTaskInfo;
    }

    @Override
    public String toString() {
        return "ReportCreation{" + "reportSubject=" + reportSubject + ", reportType=" + reportType + ", dataEtc=" + dataEtc + ", tasks=" + tasks + ", recipients=" + recipients + ", rawTaskInfo=" + rawTaskInfo + '}';
    }

}
