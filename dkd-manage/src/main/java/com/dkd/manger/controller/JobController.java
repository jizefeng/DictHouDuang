package com.dkd.manger.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.dkd.manger.domain.Job;
import com.dkd.manger.service.IJobService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 自动补货任务Controller
 * 
 * @author jzf
 * @date 2025-06-03
 */
@RestController
@RequestMapping("/manger/job")
public class JobController extends BaseController
{
    @Autowired
    private IJobService jobService;

    /**
     * 查询自动补货任务列表
     */
    @PreAuthorize("@ss.hasPermi('manger:job:list')")
    @GetMapping("/list")
    public TableDataInfo list(Job job)
    {
        startPage();
        List<Job> list = jobService.selectJobList(job);
        return getDataTable(list);
    }

    /**
     * 导出自动补货任务列表
     */
    @PreAuthorize("@ss.hasPermi('manger:job:export')")
    @Log(title = "自动补货任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Job job)
    {
        List<Job> list = jobService.selectJobList(job);
        ExcelUtil<Job> util = new ExcelUtil<Job>(Job.class);
        util.exportExcel(response, list, "自动补货任务数据");
    }

    /**
     * 获取自动补货任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('manger:job:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(jobService.selectJobById(id));
    }

    /**
     * 新增自动补货任务
     */
    @PreAuthorize("@ss.hasPermi('manger:job:add')")
    @Log(title = "自动补货任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Job job)
    {
        return toAjax(jobService.insertJob(job));
    }

    /**
     * 修改自动补货任务
     */
    @PreAuthorize("@ss.hasPermi('manger:job:edit')")
    @Log(title = "自动补货任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Job job)
    {
        return toAjax(jobService.updateJob(job));
    }

    /**
     * 删除自动补货任务
     */
    @PreAuthorize("@ss.hasPermi('manger:job:remove')")
    @Log(title = "自动补货任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jobService.deleteJobByIds(ids));
    }
}
