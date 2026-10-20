package com.pump.ai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("control_rule")
public class ControlRule {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String triggerType;
    private String expression;
    private String deviceCode;
    private String action;
    private Integer priority;
    private Integer enabled;
}
