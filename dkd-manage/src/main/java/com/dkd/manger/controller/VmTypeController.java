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
import com.dkd.manger.domain.VmType;
import com.dkd.manger.service.IVmTypeService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 设备类型管理Controller
 * 
 * @author jzf
 * @date 2025-05-29
 */
@RestController
@RequestMapping("/manger/vmType")
public class VmTypeController extends BaseController
{
    @Autowired
    private IVmTypeService vmTypeService;

    /**
     * 查询设备类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('manger:vmType:list')")
    @GetMapping("/list")
    public TableDataInfo list(VmType vmType)
    {
        startPage();
        List<VmType> list = vmTypeService.selectVmTypeList(vmType);
        return getDataTable(list);
    }

    /**
     * 导出设备类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('manger:vmType:export')")
    @Log(title = "设备类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VmType vmType)
    {
        List<VmType> list = vmTypeService.selectVmTypeList(vmType);
        ExcelUtil<VmType> util = new ExcelUtil<VmType>(VmType.class);
        util.exportExcel(response, list, "设备类型管理数据");
    }

    /**
     * 获取设备类型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manger:vmType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vmTypeService.selectVmTypeById(id));
    }

    /**
     * 新增设备类型管理
     */
    @PreAuthorize("@ss.hasPermi('manger:vmType:add')")
    @Log(title = "设备类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VmType vmType)
    {
        return toAjax(vmTypeService.insertVmType(vmType));
    }

    /**
     * 修改设备类型管理
     */
    @PreAuthorize("@ss.hasPermi('manger:vmType:edit')")
    @Log(title = "设备类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VmType vmType)
    {
        return toAjax(vmTypeService.updateVmType(vmType));
    }

    /**
     * 删除设备类型管理
     */
    @PreAuthorize("@ss.hasPermi('manger:vmType:remove')")
    @Log(title = "设备类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vmTypeService.deleteVmTypeByIds(ids));
    }
}
