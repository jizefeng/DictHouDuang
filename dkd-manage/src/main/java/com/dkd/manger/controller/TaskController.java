package com.dkd.manger.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dkd.manger.domain.TaskDetails;
import com.dkd.manger.domain.dto.TaskDto;
import com.dkd.manger.domain.vo.TaskVo;
import com.dkd.manger.service.ITaskDetailsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dkd.common.annotation.Log;
import com.dkd.common.core.controller.BaseController;
import com.dkd.common.core.domain.AjaxResult;
import com.dkd.common.enums.BusinessType;
import com.dkd.manger.domain.Task;
import com.dkd.manger.service.ITaskService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 工单Controller
 * 
 * @author jzf
 * @date 2025-06-03
 */
@RestController
@RequestMapping("/manger/task")
public class TaskController extends BaseController
{
    @Autowired
    private ITaskService taskService;
    /**
     * 查询工单列表
     */
    @PreAuthorize("@ss.hasPermi('manger:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(Task task)
    {
        startPage();
        List<TaskVo> voList = taskService.selectTaskVoList(task);
        return getDataTable(voList);
    }

    /**
     * 导出工单列表
     */
    @PreAuthorize("@ss.hasPermi('manger:task:export')")
    @Log(title = "工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Task task)
    {
        List<Task> list = taskService.selectTaskList(task);
        ExcelUtil<Task> util = new ExcelUtil<Task>(Task.class);
        util.exportExcel(response, list, "工单数据");
    }

    /**
     * 获取工单详细信息
     */
    @PreAuthorize("@ss.hasPermi('manger:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(taskService.selectTaskByTaskId(taskId));
    }

    /**
     * 新增工单
     */
    @PreAuthorize("@ss.hasPermi('manger:task:add')")
    @Log(title = "工单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskDto taskDto)
    {
        // 设置指派人（登录用户）id
        taskDto.setAssignorId(getUserId());
        return toAjax(taskService.insertTaskDto(taskDto));
    }

    /**
     * 修改工单
     */
    @PreAuthorize("@ss.hasPermi('manger:task:edit')")
    @Log(title = "工单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Task task)
    {
        return toAjax(taskService.updateTask(task));
    }

    /**
     * 删除工单
     */
    @PreAuthorize("@ss.hasPermi('manger:task:remove')")
    @Log(title = "工单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(taskService.deleteTaskByTaskIds(taskIds));
    }

    /**
     * 取消工单
     */
    @PreAuthorize("@ss.hasPermi('manger:task:edit')")
    @Log(title = "工单", businessType = BusinessType.UPDATE)
    @PutMapping("/cancel")
    public AjaxResult cancelTask(@RequestBody Task task){
        return toAjax(taskService.cancelTask(task));
    }


}
