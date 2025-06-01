package com.dkd.manger.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manger.mapper.PolicyMapper;
import com.dkd.manger.domain.Policy;
import com.dkd.manger.service.IPolicyService;

/**
 * 策略Service业务层处理
 * 
 * @author jzf
 * @date 2025-06-01
 */
@Service
public class PolicyServiceImpl implements IPolicyService 
{
    @Autowired
    private PolicyMapper policyMapper;

    /**
     * 查询策略
     * 
     * @param policyId 策略主键
     * @return 策略
     */
    @Override
    public Policy selectPolicyByPolicyId(Long policyId)
    {
        return policyMapper.selectPolicyByPolicyId(policyId);
    }

    /**
     * 查询策略列表
     * 
     * @param policy 策略
     * @return 策略
     */
    @Override
    public List<Policy> selectPolicyList(Policy policy)
    {
        return policyMapper.selectPolicyList(policy);
    }

    /**
     * 新增策略
     * 
     * @param policy 策略
     * @return 结果
     */
    @Override
    public int insertPolicy(Policy policy)
    {
        policy.setCreateTime(DateUtils.getNowDate());
        return policyMapper.insertPolicy(policy);
    }

    /**
     * 修改策略
     * 
     * @param policy 策略
     * @return 结果
     */
    @Override
    public int updatePolicy(Policy policy)
    {
        policy.setUpdateTime(DateUtils.getNowDate());
        return policyMapper.updatePolicy(policy);
    }

    /**
     * 批量删除策略
     * 
     * @param policyIds 需要删除的策略主键
     * @return 结果
     */
    @Override
    public int deletePolicyByPolicyIds(Long[] policyIds)
    {
        return policyMapper.deletePolicyByPolicyIds(policyIds);
    }

    /**
     * 删除策略信息
     * 
     * @param policyId 策略主键
     * @return 结果
     */
    @Override
    public int deletePolicyByPolicyId(Long policyId)
    {
        return policyMapper.deletePolicyByPolicyId(policyId);
    }
}
