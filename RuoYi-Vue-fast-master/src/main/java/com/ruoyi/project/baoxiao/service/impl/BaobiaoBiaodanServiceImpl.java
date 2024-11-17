package com.ruoyi.project.baoxiao.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.baoxiao.mapper.BaobiaoBiaodanMapper;
import com.ruoyi.project.baoxiao.domain.BaobiaoBiaodan;
import com.ruoyi.project.baoxiao.service.IBaobiaoBiaodanService;

/**
 * baoxiaoService业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-30
 */
@Service
public class BaobiaoBiaodanServiceImpl implements IBaobiaoBiaodanService 
{
    @Autowired
    private BaobiaoBiaodanMapper baobiaoBiaodanMapper;

    /**
     * 查询baoxiao
     * 
     * @param biaodanId baoxiao主键
     * @return baoxiao
     */
    @Override
    public BaobiaoBiaodan selectBaobiaoBiaodanByBiaodanId(Long biaodanId)
    {
        return baobiaoBiaodanMapper.selectBaobiaoBiaodanByBiaodanId(biaodanId);
    }

    /**
     * 查询baoxiao列表
     * 
     * @param baobiaoBiaodan baoxiao
     * @return baoxiao
     */
    @Override
    public List<BaobiaoBiaodan> selectBaobiaoBiaodanList(BaobiaoBiaodan baobiaoBiaodan)
    {
        return baobiaoBiaodanMapper.selectBaobiaoBiaodanList(baobiaoBiaodan);
    }

    /**
     * 新增baoxiao
     * 
     * @param baobiaoBiaodan baoxiao
     * @return 结果
     */
    @Override
    public int insertBaobiaoBiaodan(BaobiaoBiaodan baobiaoBiaodan)
    {
        return baobiaoBiaodanMapper.insertBaobiaoBiaodan(baobiaoBiaodan);
    }

    /**
     * 修改baoxiao
     * 
     * @param baobiaoBiaodan baoxiao
     * @return 结果
     */
    @Override
    public int updateBaobiaoBiaodan(BaobiaoBiaodan baobiaoBiaodan)
    {
        return baobiaoBiaodanMapper.updateBaobiaoBiaodan(baobiaoBiaodan);
    }

    /**
     * 批量删除baoxiao
     * 
     * @param biaodanIds 需要删除的baoxiao主键
     * @return 结果
     */
    @Override
    public int deleteBaobiaoBiaodanByBiaodanIds(Long[] biaodanIds)
    {
        return baobiaoBiaodanMapper.deleteBaobiaoBiaodanByBiaodanIds(biaodanIds);
    }

    /**
     * 删除baoxiao信息
     * 
     * @param biaodanId baoxiao主键
     * @return 结果
     */
    @Override
    public int deleteBaobiaoBiaodanByBiaodanId(Long biaodanId)
    {
        return baobiaoBiaodanMapper.deleteBaobiaoBiaodanByBiaodanId(biaodanId);
    }
}
