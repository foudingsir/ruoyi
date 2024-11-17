package com.ruoyi.project.baoxiao.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * baoxiao对象 baobiao_biaodan
 * 
 * @author ruoyi
 * @date 2024-10-30
 */
public class BaobiaoBiaodan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表单id */
    private Long biaodanId;

    /** 报销人编号 */
    @Excel(name = "报销人编号")
    private Long userId;

    /** 报销人姓名 */
    @Excel(name = "报销人姓名")
    private String userName;

    /** 报销人部门 */
    @Excel(name = "报销人部门")
    private String deptName;

    /** 报销金额 */
    @Excel(name = "报销金额")
    private Long amount;

    /** 报销事由 */
    @Excel(name = "报销事由")
    private String reason;

    /** 报销申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报销申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 附件 */
    @Excel(name = "附件")
    private String file;

    public void setBiaodanId(Long biaodanId) 
    {
        this.biaodanId = biaodanId;
    }

    public Long getBiaodanId() 
    {
        return biaodanId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setFile(String file) 
    {
        this.file = file;
    }

    public String getFile() 
    {
        return file;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("biaodanId", getBiaodanId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("deptName", getDeptName())
            .append("amount", getAmount())
            .append("reason", getReason())
            .append("date", getDate())
            .append("file", getFile())
            .toString();
    }
}
