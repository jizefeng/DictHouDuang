package com.dkd.manger.service;

import java.util.List;
import com.dkd.manger.domain.Policy;

/**
 * 策略Service接口
 * 
 * @author jzf
 * @date 2025-06-01
 */
public interface IPolicyService 
{
    /**
     * 查询策略
     * 
     * @param policyId 策略主键
     * @return 策略
     */
    public Policy selectPolicyByPolicyId(Long policyId);

    /**
     * 查询策略列表
     * 
     * @param policy 策略
     * @return 策略集合
     */
    public List<Policy> selectPolicyList(Policy policy);

    /**
     * 新增策略
     * 
     * @param policy 策略
     * @return 结果
     */
    public int insertPolicy(Policy policy);

    /**
     * 修改策略
     * 
     * @param policy 策略
     * @return 结果
     */
    public int updatePolicy(Policy policy);

    /**
     * 批量删除策略
     * 
     * @param policyIds 需要删除的策略主键集合
     * @return 结果
     */
    public int deletePolicyByPolicyIds(Long[] policyIds);

    /**
     * 删除策略信息
     * 
     * @param policyId 策略主键
     * @return 结果
     */
    public int deletePolicyByPolicyId(Long policyId);
}
