package com.pal.intern.domain;

import org.hibernate.validator.constraints.Range;

public class ReportRecipient {

    private String reportRecipientEmail;
    @Range(min = 1, max = 2, message = "recipient action value is not valid")
    private int reportRecipientAction;

    public ReportRecipient(String reportRecipientEmail, int reportRecipientAction) {
        this.reportRecipientEmail = reportRecipientEmail;
        this.reportRecipientAction = reportRecipientAction;
    }

    public ReportRecipient() {
    }

    public String getReportRecipientEmail() {
        return reportRecipientEmail;
    }

    public int getReportRecipientAction() {
        return reportRecipientAction;
    }

    public void setReportRecipientEmail(String reportRecipientEmail) {
        this.reportRecipientEmail = reportRecipientEmail;
    }

    public void setReportRecipientAction(int reportRecipientAction) {
        this.reportRecipientAction = reportRecipientAction;
    }

    @Override
    public String toString() {
        return "ReportRecipient{" + "reportRecipientEmail=" + reportRecipientEmail + ", reportRecipientAction=" + reportRecipientAction + '}';
    }

}
