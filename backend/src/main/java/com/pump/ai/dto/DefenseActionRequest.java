package com.pump.ai.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DefenseActionRequest {
    @NotBlank
    private String action;
    private Integer delaySeconds;
    private String reason;
}
