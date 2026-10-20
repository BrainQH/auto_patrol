package com.pump.ai.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ControlActionRequest {
    @NotBlank
    private String deviceCode;
    @NotBlank
    private String operation;
    private Double targetValue;
}
