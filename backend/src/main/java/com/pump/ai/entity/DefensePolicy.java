package com.pump.ai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("defense_policy")
public class DefensePolicy {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String policyName;
    private Integer disarmSeconds;
    private Integer rearmSeconds;
    private String status;
    private String zonesJson;
}
