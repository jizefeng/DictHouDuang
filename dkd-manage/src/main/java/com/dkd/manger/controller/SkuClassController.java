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
import com.dkd.manger.domain.SkuClass;
import com.dkd.manger.service.ISkuClassService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 商品类型Controller
 * 
 * @author jzf
 * @date 2025-06-01
 */
@RestController
@RequestMapping("/manger/SkuClass")
public class SkuClassController extends BaseController
{
    @Autowired
    private ISkuClassService skuClassService;

    /**
     * 查询商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('manger:SkuClass:list')")
    @GetMapping("/list")
    public TableDataInfo list(SkuClass skuClass)
    {
        startPage();
        List<SkuClass> list = skuClassService.selectSkuClassList(skuClass);
        return getDataTable(list);
    }

    /**
     * 导出商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('manger:SkuClass:export')")
    @Log(title = "商品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SkuClass skuClass)
    {
        List<SkuClass> list = skuClassService.selectSkuClassList(skuClass);
        ExcelUtil<SkuClass> util = new ExcelUtil<SkuClass>(SkuClass.class);
        util.exportExcel(response, list, "商品类型数据");
    }

    /**
     * 获取商品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('manger:SkuClass:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return success(skuClassService.selectSkuClassByClassId(classId));
    }

    /**
     * 新增商品类型
     */
    @PreAuthorize("@ss.hasPermi('manger:SkuClass:add')")
    @Log(title = "商品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SkuClass skuClass)
    {
        return toAjax(skuClassService.insertSkuClass(skuClass));
    }

    /**
     * 修改商品类型
     */
    @PreAuthorize("@ss.hasPermi('manger:SkuClass:edit')")
    @Log(title = "商品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SkuClass skuClass)
    {
        return toAjax(skuClassService.updateSkuClass(skuClass));
    }

    /**
     * 删除商品类型
     */
    @PreAuthorize("@ss.hasPermi('manger:SkuClass:remove')")
    @Log(title = "商品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(skuClassService.deleteSkuClassByClassIds(classIds));
    }
}
