package com.pump.ai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("inspection_task")
public class InspectionTask {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String mode;
    private String routeCode;
    private String status;
    private LocalDateTime planStartTime;
    private LocalDateTime planEndTime;
    private Integer pointsTotal;
    private Integer abnormalCount;
    private String reportUrl;
    private LocalDateTime createdAt;
}
