package com.ruoyi.project.system.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 報銷
 *
 * @author ruoyi
 */
@Data
public class SysBaoxiao extends BaseEntity
{
    /** 角色ID */
    //private Long roleId;

    /** 菜单ID */
    private String name;

    private String department;

    private Long amount;

    private String reason;

    private String date;

}
