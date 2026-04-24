package com.pump.ai.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InspectionStartRequest {
    @NotBlank
    private String mode;
    @NotBlank
    private String routeCode;
}
