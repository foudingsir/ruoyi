package com.ruoyi.project.baoxiao.service;

import java.util.List;
import com.ruoyi.project.baoxiao.domain.BaobiaoBiaodan;

/**
 * baoxiaoService接口
 * 
 * @author ruoyi
 * @date 2024-10-30
 */
public interface IBaobiaoBiaodanService 
{
    /**
     * 查询baoxiao
     * 
     * @param biaodanId baoxiao主键
     * @return baoxiao
     */
    public BaobiaoBiaodan selectBaobiaoBiaodanByBiaodanId(Long biaodanId);

    /**
     * 查询baoxiao列表
     * 
     * @param baobiaoBiaodan baoxiao
     * @return baoxiao集合
     */
    public List<BaobiaoBiaodan> selectBaobiaoBiaodanList(BaobiaoBiaodan baobiaoBiaodan);

    /**
     * 新增baoxiao
     * 
     * @param baobiaoBiaodan baoxiao
     * @return 结果
     */
    public int insertBaobiaoBiaodan(BaobiaoBiaodan baobiaoBiaodan);

    /**
     * 修改baoxiao
     * 
     * @param baobiaoBiaodan baoxiao
     * @return 结果
     */
    public int updateBaobiaoBiaodan(BaobiaoBiaodan baobiaoBiaodan);

    /**
     * 批量删除baoxiao
     * 
     * @param biaodanIds 需要删除的baoxiao主键集合
     * @return 结果
     */
    public int deleteBaobiaoBiaodanByBiaodanIds(Long[] biaodanIds);

    /**
     * 删除baoxiao信息
     * 
     * @param biaodanId baoxiao主键
     * @return 结果
     */
    public int deleteBaobiaoBiaodanByBiaodanId(Long biaodanId);
}
