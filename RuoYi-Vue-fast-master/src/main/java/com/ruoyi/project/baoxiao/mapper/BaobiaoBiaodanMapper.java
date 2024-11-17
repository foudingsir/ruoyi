package com.ruoyi.project.baoxiao.mapper;

import java.util.List;
import com.ruoyi.project.baoxiao.domain.BaobiaoBiaodan;

/**
 * baoxiaoMapper接口
 * 
 * @author ruoyi
 * @date 2024-10-30
 */
public interface BaobiaoBiaodanMapper 
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
     * 删除baoxiao
     * 
     * @param biaodanId baoxiao主键
     * @return 结果
     */
    public int deleteBaobiaoBiaodanByBiaodanId(Long biaodanId);

    /**
     * 批量删除baoxiao
     * 
     * @param biaodanIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaobiaoBiaodanByBiaodanIds(Long[] biaodanIds);
}
