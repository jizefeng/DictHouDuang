package com.dkd.manger.mapper;

import java.util.List;
import com.dkd.manger.domain.Job;

/**
 * 自动补货任务Mapper接口
 * 
 * @author jzf
 * @date 2025-06-03
 */
public interface JobMapper 
{
    /**
     * 查询自动补货任务
     * 
     * @param id 自动补货任务主键
     * @return 自动补货任务
     */
    public Job selectJobById(Long id);

    /**
     * 查询自动补货任务列表
     * 
     * @param job 自动补货任务
     * @return 自动补货任务集合
     */
    public List<Job> selectJobList(Job job);

    /**
     * 新增自动补货任务
     * 
     * @param job 自动补货任务
     * @return 结果
     */
    public int insertJob(Job job);

    /**
     * 修改自动补货任务
     * 
     * @param job 自动补货任务
     * @return 结果
     */
    public int updateJob(Job job);

    /**
     * 删除自动补货任务
     * 
     * @param id 自动补货任务主键
     * @return 结果
     */
    public int deleteJobById(Long id);

    /**
     * 批量删除自动补货任务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobByIds(Long[] ids);
}
