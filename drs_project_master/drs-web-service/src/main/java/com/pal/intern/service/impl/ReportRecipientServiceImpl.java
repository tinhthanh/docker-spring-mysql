package com.pal.intern.service.impl;

import com.pal.intern.domain.ReportRecipient;
import com.pal.intern.repository.ReportRecipientRepository;
import com.pal.intern.service.ReportRecipientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportRecipientServiceImpl implements ReportRecipientService {

    @Autowired
    private ReportRecipientRepository reportRecipientRepository;

    @Override
    public int createReportRecipient(String reportRecipentEmail, int reportRecipentAction, int reportId) {
        return this.reportRecipientRepository.createReportRecipient(reportRecipentEmail, reportRecipentAction, reportId);
    }

    @Override
    public List<ReportRecipient> getListRecipientByReportId(int reportId) {
        return this.reportRecipientRepository.getListRecipientByReportId(reportId);
    }

}
