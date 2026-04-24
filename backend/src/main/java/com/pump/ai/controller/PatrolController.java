package com.pump.ai.controller;

import com.pump.ai.dto.ControlActionRequest;
import com.pump.ai.dto.DefenseActionRequest;
import com.pump.ai.dto.InspectionStartRequest;
import com.pump.ai.entity.AlertEvent;
import com.pump.ai.entity.InspectionTask;
import com.pump.ai.service.PatrolService;
import com.pump.ai.service.TdEngineTelemetryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "AI巡检核心接口")
public class PatrolController {

    private final PatrolService patrolService;
    private final TdEngineTelemetryService telemetryService;

    @PostMapping("/inspections/start")
    @Operation(summary = "启动巡检", description = "支持主动、全站、例行、特殊天气巡检")
    public InspectionTask start(@RequestBody @Valid InspectionStartRequest request) {
        return patrolService.startInspection(request);
    }

    @PostMapping("/defense/action")
    @Operation(summary = "布防/撤防")
    public Map<String, Object> defense(@RequestBody @Valid DefenseActionRequest request) {
        return patrolService.doDefenseAction(request);
    }

    @PostMapping("/devices/control")
    @Operation(summary = "设备运行控制")
    public Map<String, Object> control(@RequestBody @Valid ControlActionRequest request) {
        return patrolService.controlDevice(request);
    }

    @GetMapping("/alerts/latest")
    @Operation(summary = "最新告警")
    public List<AlertEvent> alerts() {
        return patrolService.latestAlerts();
    }

    @GetMapping("/predict/trend")
    @Operation(summary = "趋势预测")
    public Map<String, Object> prediction() {
        return patrolService.trendPrediction();
    }

    @GetMapping("/telemetry/{deviceCode}")
    @Operation(summary = "查询TDengine时序数据")
    public List<Map<String, Object>> telemetry(@PathVariable String deviceCode) {
        return telemetryService.latestTelemetry(deviceCode);
    }
}
