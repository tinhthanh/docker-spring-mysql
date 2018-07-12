package com.pal.intern.service.impl;

import com.pal.intern.domain.Report;
import com.pal.intern.domain.ReportCreation;
import com.pal.intern.domain.ReportRecipient;
import com.pal.intern.domain.Task;
import com.pal.intern.domain.TaskCreation;
import com.pal.intern.domain.User;
import com.pal.intern.repository.ReportRecipientRepository;
import com.pal.intern.repository.ReportRepository;
import com.pal.intern.repository.TaskRepository;
import com.pal.intern.service.MailService;
import com.pal.intern.service.ReportService;
import com.pal.intern.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportServiceImpl implements ReportService {

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ReportRecipientRepository reportRecipientRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @Override
    public int createReport(String reportSubject, int reportType, String reportDataEtc, int userId) {
        return this.reportRepository.createReport(reportSubject, reportType, reportDataEtc, userId);
    }

    @Transactional
    @Override
    public int saveReport(ReportCreation reportCreation, int userId) throws DataAccessException {
        int reportId = this.reportRepository.createReport(reportCreation.getReportSubject(), reportCreation.getReportType(), reportCreation.getDataEtc(), userId);
        if (reportId != -1) {
            // save task and report
            List<TaskCreation> tcs = reportCreation.getTasks();
            int taskId[] = new int[1];
            tcs.forEach(t -> {
                taskId[0] = this.taskRepository.saveTask(t.getTaskName(), t.getDescription(), t.getTargetDate(), t.getTaskStatus(), t.getRemark(), t.getTaskDateDefined(), reportId);
                this.LOGGER.info(taskId[0] + " task id after saved ");
            });

            List<ReportRecipient> rrcs = reportCreation.getRecipients();
            int reportRecipientId[] = new int[1];
            rrcs.forEach(r -> {
                reportRecipientId[0] = this.reportRecipientRepository.createReportRecipient(r.getReportRecipientEmail(), r.getReportRecipientAction(), reportId);
                this.LOGGER.info(reportRecipientId[0] + " reportRecipientId after save");
            });

        }
        if (reportCreation.getReportType() == 2) {
            Map<String, Object> dataSend = new HashMap<>();
            dataSend.put("subject", reportCreation.getReportSubject());
            dataSend.put("body", reportCreation.getRawTaskInfo());
            List<EmailAddress> to = new ArrayList<>();
            List<EmailAddress> cc = new ArrayList<>();
            List<ReportRecipient> rrcs = reportCreation.getRecipients();
            rrcs.forEach(r -> {
                if (r.getReportRecipientAction() == 1) {
                    to.add(new EmailAddress(r.getReportRecipientEmail()));
                } else if (r.getReportRecipientAction() == 2) {
                    cc.add(new EmailAddress(r.getReportRecipientEmail()));
                }
            });
            Optional<User> user = userService.getUserByUserId(userId);
            String reportOwnerEmail[] = {null};
            user.ifPresent(u -> {
                reportOwnerEmail[0] = u.getEmail();
            });
            cc.add(new EmailAddress(reportOwnerEmail[0]));
            dataSend.put("cc", cc);
            dataSend.put("to", to);
            try {
                mailService.sendMail(dataSend);
            } catch (Exception ex) {
                LOGGER.error("Error when call method saveReport() with param " + Arrays.asList(reportCreation, userId), ex);
            }
        }

        return reportId;

    }

    @Override
    public Optional<Report> getReportById(int reportId) {
        return this.reportRepository.getReportById(reportId);
    }

    @Override
    public Map<String, Object> getReportByIdWithRecipientAndTasks(int reportId) {

        Map<String, Object> result = new HashMap<>();

        Optional<Report> report = this.reportRepository.getReportById(reportId);
        if (report.isPresent()) {
            List<Task> tasks = this.taskRepository.getListTaskByReportId(reportId);
            List<ReportRecipient> recipients = this.reportRecipientRepository.getListRecipientByReportId(reportId);
            result.put("report", report.get());
            result.put("tasks", tasks);
            result.put("recipients", recipients);
        }

        return result;
    }

    @Override
    public Map<String, Object> getReportByUserIdAndStatusWithPaging(int userId, int reportType, int page, int pageSize) {
        return this.reportRepository.getReportByUserIdAndStatusWithPaging(userId, reportType, page, pageSize);
    }

    @Override
    public int updateReportByReportId(Report report) {
        if (report.getReportType() >= 0 && report.getReportType() <= 3) {
            return reportRepository.updateReportByReportId(report);
        }
        return 0;
    }

    @Override
    public int deleteReportByReportId(int reportId) {
        return reportRepository.deleteReportByReportId(reportId);
    }

}
