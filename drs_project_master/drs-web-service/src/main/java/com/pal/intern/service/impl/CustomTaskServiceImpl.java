package com.pal.intern.service.impl;

import com.pal.intern.domain.CustomTask;
import com.pal.intern.mapper.CustomTaskQueryStatements;
import com.pal.intern.repository.CustomTaskRepository;
import com.pal.intern.service.CustomTaskService;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomTaskServiceImpl implements CustomTaskService {

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());
    @Autowired
    private CustomTaskRepository customTaskRepository;

    @Override
    public Map<String, Object> getCustomTaskWithPaging(int userID, int page, int pageSize) {
        return customTaskRepository.getCustomTaskWithPaging(userID, page, pageSize);
    }

    @Override
    public int createCustomTask(CustomTask model) {
        return this.customTaskRepository.createCustomTask(model);
    }

    @Override
    public Optional<CustomTask> getCustomTaskByID(int id) {
        return this.customTaskRepository.getCustomTaskByID(id);
    }

    @Override
    public boolean isCustomTaskOwner(int customTaskID, int userID) {
        return this.customTaskRepository.isCustomTaskOwner(customTaskID, userID);
    }

    @Override
    public boolean deleteCustomTask(int customTaskID) {
        return this.customTaskRepository.deleteCustomTask(customTaskID);
    }

    @Override
    public boolean isDeleted(int customTaskID) {
        return this.customTaskRepository.isDeleted(customTaskID);
    }

    @Override
    public Optional<CustomTask> updateCustomTask(CustomTask model) {
        return this.customTaskRepository.updateCustomTaskAllField(model);
    }

    @Override
    public int updateCustomTaskOneField(CustomTask model) {
        int numEffectRows = 0;
        Optional<CustomTask> oldChange = this.customTaskRepository.getCustomTaskByID(model.getId());
        if (!model.getName().equals(oldChange.get().getName())) {
            numEffectRows += this.customTaskRepository.updateCustomTaskOneField(CustomTaskQueryStatements.CUSTOM_TASK_NAME_COL, model.getName(), model.getId());
        }
        if (!model.getDescription().equals(oldChange.get().getDescription())) {
            numEffectRows += this.customTaskRepository.updateCustomTaskOneField(CustomTaskQueryStatements.CUSTOM_TASK_DESCRIPTION_COL, model.getDescription(), model.getId());
        }
        if (model.getTargetDate().getTime() != oldChange.get().getTargetDate().getTime()) {
            numEffectRows += this.customTaskRepository.updateCustomTaskOneField(CustomTaskQueryStatements.CUSTOM_TASK_TARGET_DATE_COL, model.getTargetDate(), model.getId());
        }
        if (model.getTaskStatus() != oldChange.get().getTaskStatus()) {
            numEffectRows += this.customTaskRepository.updateCustomTaskOneField(CustomTaskQueryStatements.CUSTOM_TASK_TASK_STATUS_COL, model.getTaskStatus(), model.getId());
        }
        if (!model.getRemark().equals(oldChange.get().getRemark())) {
            numEffectRows += this.customTaskRepository.updateCustomTaskOneField(CustomTaskQueryStatements.CUSTOM_TASK_REMARK_COL, model.getRemark(), model.getId());
        }
        return numEffectRows;
    }

}
