package com.dkd.manger.mapper;

import java.util.List;
import com.dkd.manger.domain.Region;
import com.dkd.manger.domain.vo.RegionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 区域管理Mapper接口
 * 
 * @author jzf
 * @date 2025-05-24
 */
@Mapper
public interface RegionMapper 
{
    /**
     * 查询区域管理
     * 
     * @param id 区域管理主键
     * @return 区域管理
     */
    public Region selectRegionById(Long id);

    /**
     * 查询区域管理列表
     * 
     * @param region 区域管理
     * @return 区域管理集合
     */
    public List<Region> selectRegionList(Region region);

    /**
     * 新增区域管理
     * 
     * @param region 区域管理
     * @return 结果
     */
    public int insertRegion(Region region);

    /**
     * 修改区域管理
     * 
     * @param region 区域管理
     * @return 结果
     */
    public int updateRegion(Region region);

    /**
     * 删除区域管理
     * 
     * @param id 区域管理主键
     * @return 结果
     */
    public int deleteRegionById(Long id);

    /**
     * 批量删除区域管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRegionByIds(Long[] ids);
    /**
     * 查询区域管理列表
     *
     * @param region 区域管理
     * @return 区域管理集合
     */
    List<RegionVo> selectRegionListVo(Region region);

}
