package com.pump.ai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("alert_event")
public class AlertEvent {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String category;
    private String level;
    private String location;
    private String detail;
    private String processStatus;
    private LocalDateTime eventTime;
    private Boolean linkedControl;
}
