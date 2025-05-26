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
import com.dkd.manger.domain.TbPartner;
import com.dkd.manger.service.ITbPartnerService;
import com.dkd.common.utils.poi.ExcelUtil;
import com.dkd.common.core.page.TableDataInfo;

/**
 * 合作商Controller
 * 
 * @author ruoyi
 * @date 2025-05-24
 */
@RestController
@RequestMapping("/manger/partner")
public class TbPartnerController extends BaseController
{
    @Autowired
    private ITbPartnerService tbPartnerService;

    /**
     * 查询合作商列表
     */
    @PreAuthorize("@ss.hasPermi('manger:partner:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbPartner tbPartner)
    {
        startPage();
        List<TbPartner> list = tbPartnerService.selectTbPartnerList(tbPartner);
        return getDataTable(list);
    }

    /**
     * 导出合作商列表
     */
    @PreAuthorize("@ss.hasPermi('manger:partner:export')")
    @Log(title = "合作商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbPartner tbPartner)
    {
        List<TbPartner> list = tbPartnerService.selectTbPartnerList(tbPartner);
        ExcelUtil<TbPartner> util = new ExcelUtil<TbPartner>(TbPartner.class);
        util.exportExcel(response, list, "合作商数据");
    }

    /**
     * 获取合作商详细信息
     */
    @PreAuthorize("@ss.hasPermi('manger:partner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbPartnerService.selectTbPartnerById(id));
    }

    /**
     * 新增合作商
     */
    @PreAuthorize("@ss.hasPermi('manger:partner:add')")
    @Log(title = "合作商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbPartner tbPartner)
    {
        return toAjax(tbPartnerService.insertTbPartner(tbPartner));
    }

    /**
     * 修改合作商
     */
    @PreAuthorize("@ss.hasPermi('manger:partner:edit')")
    @Log(title = "合作商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbPartner tbPartner)
    {
        return toAjax(tbPartnerService.updateTbPartner(tbPartner));
    }

    /**
     * 删除合作商
     */
    @PreAuthorize("@ss.hasPermi('manger:partner:remove')")
    @Log(title = "合作商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbPartnerService.deleteTbPartnerByIds(ids));
    }
}
