package com.dkd.manger.mapper;

import java.util.List;
import com.dkd.manger.domain.VmType;

/**
 * 设备类型管理Mapper接口
 * 
 * @author jzf
 * @date 2025-05-29
 */
public interface VmTypeMapper 
{
    /**
     * 查询设备类型管理
     * 
     * @param id 设备类型管理主键
     * @return 设备类型管理
     */
    public VmType selectVmTypeById(Long id);

    /**
     * 查询设备类型管理列表
     * 
     * @param vmType 设备类型管理
     * @return 设备类型管理集合
     */
    public List<VmType> selectVmTypeList(VmType vmType);

    /**
     * 新增设备类型管理
     * 
     * @param vmType 设备类型管理
     * @return 结果
     */
    public int insertVmType(VmType vmType);

    /**
     * 修改设备类型管理
     * 
     * @param vmType 设备类型管理
     * @return 结果
     */
    public int updateVmType(VmType vmType);

    /**
     * 删除设备类型管理
     * 
     * @param id 设备类型管理主键
     * @return 结果
     */
    public int deleteVmTypeById(Long id);

    /**
     * 批量删除设备类型管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVmTypeByIds(Long[] ids);
}
