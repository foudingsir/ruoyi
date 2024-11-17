package com.ruoyi.project.baoxiao.controller;

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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.baoxiao.domain.BaobiaoBiaodan;
import com.ruoyi.project.baoxiao.service.IBaobiaoBiaodanService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * baoxiaoController
 * 
 * @author ruoyi
 * @date 2024-10-30
 */
@RestController
@RequestMapping("/baoxiao/biaodan")
public class BaobiaoBiaodanController extends BaseController
{
    @Autowired
    private IBaobiaoBiaodanService baobiaoBiaodanService;

    /**
     * 查询baoxiao列表
     */
    @PreAuthorize("@ss.hasPermi('baoxiao:biaodan:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaobiaoBiaodan baobiaoBiaodan)
    {
        startPage();
        List<BaobiaoBiaodan> list = baobiaoBiaodanService.selectBaobiaoBiaodanList(baobiaoBiaodan);
        return getDataTable(list);
    }

    /**
     * 导出baoxiao列表
     */
    @PreAuthorize("@ss.hasPermi('baoxiao:biaodan:export')")
    @Log(title = "baoxiao", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaobiaoBiaodan baobiaoBiaodan)
    {
        List<BaobiaoBiaodan> list = baobiaoBiaodanService.selectBaobiaoBiaodanList(baobiaoBiaodan);
        ExcelUtil<BaobiaoBiaodan> util = new ExcelUtil<BaobiaoBiaodan>(BaobiaoBiaodan.class);
        util.exportExcel(response, list, "baoxiao数据");
    }

    /**
     * 获取baoxiao详细信息
     */
    @PreAuthorize("@ss.hasPermi('baoxiao:biaodan:query')")
    @GetMapping(value = "/{biaodanId}")
    public AjaxResult getInfo(@PathVariable("biaodanId") Long biaodanId)
    {
        return success(baobiaoBiaodanService.selectBaobiaoBiaodanByBiaodanId(biaodanId));
    }

    /**
     * 新增baoxiao
     */
    @PreAuthorize("@ss.hasPermi('baoxiao:biaodan:add')")
    @Log(title = "baoxiao", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaobiaoBiaodan baobiaoBiaodan)
    {
        return toAjax(baobiaoBiaodanService.insertBaobiaoBiaodan(baobiaoBiaodan));
    }

    /**
     * 修改baoxiao
     */
    @PreAuthorize("@ss.hasPermi('baoxiao:biaodan:edit')")
    @Log(title = "baoxiao", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaobiaoBiaodan baobiaoBiaodan)
    {
        return toAjax(baobiaoBiaodanService.updateBaobiaoBiaodan(baobiaoBiaodan));
    }

    /**
     * 删除baoxiao
     */
    @PreAuthorize("@ss.hasPermi('baoxiao:biaodan:remove')")
    @Log(title = "baoxiao", businessType = BusinessType.DELETE)
	@DeleteMapping("/{biaodanIds}")
    public AjaxResult remove(@PathVariable Long[] biaodanIds)
    {
        return toAjax(baobiaoBiaodanService.deleteBaobiaoBiaodanByBiaodanIds(biaodanIds));
    }
}
