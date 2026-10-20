package com.pump.ai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("recognition_event")
public class RecognitionEvent {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String sceneType;
    private String target;
    private Double confidence;
    private String imageUrl;
    private String result;
    private String cameraCode;
    private LocalDateTime capturedAt;
}
