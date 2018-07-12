package com.pal.intern.service;

import com.pal.intern.domain.ReportRecipient;
import java.util.List;

public interface ReportRecipientService {

    public int createReportRecipient(String reportRecipentEmail, int reportRecipentAction, int reportId);

    public List<ReportRecipient> getListRecipientByReportId(int reportId);
}
