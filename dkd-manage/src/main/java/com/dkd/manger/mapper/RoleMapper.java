package com.dkd.manger.mapper;

import java.util.List;
import com.dkd.manger.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理Mapper接口
 * 
 * @author jzf
 * @date 2025-05-28
 */
@Mapper
public interface RoleMapper 
{
    /**
     * 查询角色管理
     * 
     * @param roleId 角色管理主键
     * @return 角色管理
     */
    public Role selectRoleByRoleId(Long roleId);

    /**
     * 查询角色管理列表
     * 
     * @param role 角色管理
     * @return 角色管理集合
     */
    public List<Role> selectRoleList(Role role);

    /**
     * 新增角色管理
     * 
     * @param role 角色管理
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改角色管理
     * 
     * @param role 角色管理
     * @return 结果
     */
    public int updateRole(Role role);

    /**
     * 删除角色管理
     * 
     * @param roleId 角色管理主键
     * @return 结果
     */
    public int deleteRoleByRoleId(Long roleId);

    /**
     * 批量删除角色管理
     * 
     * @param roleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRoleByRoleIds(Long[] roleIds);
}
