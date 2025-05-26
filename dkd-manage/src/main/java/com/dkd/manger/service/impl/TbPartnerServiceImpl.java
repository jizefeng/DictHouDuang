package com.dkd.manger.service.impl;

import java.util.List;
import com.dkd.common.utils.DateUtils;
import com.dkd.common.utils.SecurityUtils;
import com.dkd.manger.domain.vo.PartnerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manger.mapper.TbPartnerMapper;
import com.dkd.manger.domain.TbPartner;
import com.dkd.manger.service.ITbPartnerService;

/**
 * 合作商Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-24
 */
@Service
public class TbPartnerServiceImpl implements ITbPartnerService 
{
    @Autowired
    private TbPartnerMapper tbPartnerMapper;

    /**
     * 查询合作商
     * 
     * @param id 合作商主键
     * @return 合作商
     */
    @Override
    public TbPartner selectTbPartnerById(Long id)
    {
        return tbPartnerMapper.selectTbPartnerById(id);
    }

    /**
     * 查询合作商列表
     * 
     * @param tbPartner 合作商
     * @return 合作商
     */
    @Override
    public List<TbPartner> selectTbPartnerList(TbPartner tbPartner)
    {
        return tbPartnerMapper.selectTbPartnerList(tbPartner);
    }

    /**
     * 新增合作商
     * 
     * @param tbPartner 合作商
     * @return 结果
     */
    @Override
    public int insertTbPartner(TbPartner tbPartner)
    {
        tbPartner.setPassword(SecurityUtils.encryptPassword(tbPartner.getPassword()));
        tbPartner.setCreateTime(DateUtils.getNowDate());
        return tbPartnerMapper.insertTbPartner(tbPartner);
    }

    /**
     * 修改合作商
     * 
     * @param tbPartner 合作商
     * @return 结果
     */
    @Override
    public int updateTbPartner(TbPartner tbPartner)
    {
        tbPartner.setUpdateTime(DateUtils.getNowDate());
        return tbPartnerMapper.updateTbPartner(tbPartner);
    }

    /**
     * 批量删除合作商
     * 
     * @param ids 需要删除的合作商主键
     * @return 结果
     */
    @Override
    public int deleteTbPartnerByIds(Long[] ids)
    {
        return tbPartnerMapper.deleteTbPartnerByIds(ids);
    }

    /**
     * 删除合作商信息
     * 
     * @param id 合作商主键
     * @return 结果
     */
    @Override
    public int deleteTbPartnerById(Long id)
    {
        return tbPartnerMapper.deleteTbPartnerById(id);
    }

    /**
     * 查询合作商管理列表
     * @param partner
     * @return partnerVo集合
     */
    @Override
    public List<PartnerVo> selectPartnerVoList(TbPartner partner) {
        return tbPartnerMapper.selectPartnerVoList(partner);
    }
}
