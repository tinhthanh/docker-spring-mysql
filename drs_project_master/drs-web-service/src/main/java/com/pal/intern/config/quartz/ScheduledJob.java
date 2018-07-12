package com.pal.intern.config.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduledJob extends QuartzJobBean {

    private JobBean jobBean;

    @Override
    protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
//        jobBean.evictCacheForParamConfig();
//        jobBean.loadDataTocache();
        jobBean.getIssueChangeStatus();
    }

    public JobBean getJobBean() {
        return jobBean;
    }

    public void setJobBean(JobBean jobBean) {
        this.jobBean = jobBean;
    }
    
    

}
