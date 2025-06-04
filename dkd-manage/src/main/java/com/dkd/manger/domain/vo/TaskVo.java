package com.dkd.manger.domain.vo;

import com.dkd.manger.domain.Task;
import com.dkd.manger.domain.TaskType;
import lombok.Data;

@Data
public class TaskVo extends Task {
    // 工单类型
    private TaskType taskType;
}
