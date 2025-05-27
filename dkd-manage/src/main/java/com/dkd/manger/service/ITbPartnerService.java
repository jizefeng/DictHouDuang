package com.dkd.manger.service;

import java.util.List;
import com.dkd.manger.domain.TbPartner;
import com.dkd.manger.domain.vo.PartnerVo;

/**
 * 合作商Service接口
 * 
 * @author ruoyi
 * @date 2025-05-24
 */
public interface ITbPartnerService 
{
    /**
     * 查询合作商
     * 
     * @param id 合作商主键
     * @return 合作商
     */
    public TbPartner selectTbPartnerById(Long id);

    /**
     * 查询合作商列表
     * 
     * @param tbPartner 合作商
     * @return 合作商集合
     */
    public List<TbPartner> selectTbPartnerList(TbPartner tbPartner);

    /**
     * 新增合作商
     * 
     * @param tbPartner 合作商
     * @return 结果
     */
    public int insertTbPartner(TbPartner tbPartner);

    /**
     * 修改合作商
     * 
     * @param tbPartner 合作商
     * @return 结果
     */
    public int updateTbPartner(TbPartner tbPartner);

    /**
     * 批量删除合作商
     * 
     * @param ids 需要删除的合作商主键集合
     * @return 结果
     */
    public int deleteTbPartnerByIds(Long[] ids);

    /**
     * 删除合作商信息
     * 
     * @param id 合作商主键
     * @return 结果
     */
    public int deleteTbPartnerById(Long id);
    /**
     * 查询合作商管理列表
     * @param partner
     * @return partnerVo集合
     */
    List<PartnerVo> selectPartnerVoList(TbPartner partner);

}
