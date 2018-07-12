package com.pal.intern.repository;

import com.pal.intern.domain.ReportRecipient;
import java.util.List;

public interface ReportRecipientRepository {

    public int createReportRecipient(String reportRecipentEmail, int reportRecipentAction, int reportId);
    
    public List<ReportRecipient> getListRecipientByReportId(int reportId);

}
