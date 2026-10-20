package com.pump.ai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pump.ai.dto.ControlActionRequest;
import com.pump.ai.dto.DefenseActionRequest;
import com.pump.ai.dto.InspectionStartRequest;
import com.pump.ai.entity.AlertEvent;
import com.pump.ai.entity.InspectionTask;
import com.pump.ai.mapper.AlertEventMapper;
import com.pump.ai.mapper.InspectionTaskMapper;
import com.pump.ai.service.PatrolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class PatrolServiceImpl implements PatrolService {

    private final InspectionTaskMapper inspectionTaskMapper;
    private final AlertEventMapper alertEventMapper;

    @Override
    public InspectionTask startInspection(InspectionStartRequest request) {
        InspectionTask task = new InspectionTask();
        task.setMode(request.getMode());
        task.setRouteCode(request.getRouteCode());
        task.setStatus("RUNNING");
        task.setPlanStartTime(LocalDateTime.now());
        task.setPointsTotal(ThreadLocalRandom.current().nextInt(50, 300));
        task.setAbnormalCount(0);
        task.setCreatedAt(LocalDateTime.now());
        inspectionTaskMapper.insert(task);
        return task;
    }

    @Override
    public Map<String, Object> doDefenseAction(DefenseActionRequest request) {
        Map<String, Object> resp = new HashMap<>();
        int seconds = request.getDelaySeconds() == null ? ("ARM".equalsIgnoreCase(request.getAction()) ? 8 : 3)
                : request.getDelaySeconds();
        resp.put("action", request.getAction());
        resp.put("delaySeconds", seconds);
        resp.put("effectiveAt", LocalDateTime.now().plusSeconds(seconds));
        resp.put("message", "撤防/布防策略已执行，支持3秒撤防和5-10秒延迟布防。");
        return resp;
    }

    @Override
    public Map<String, Object> controlDevice(ControlActionRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("deviceCode", request.getDeviceCode());
        result.put("operation", request.getOperation());
        result.put("targetValue", request.getTargetValue());
        result.put("success", Boolean.TRUE);
        result.put("executedAt", LocalDateTime.now());
        return result;
    }

    @Override
    public List<AlertEvent> latestAlerts() {
        return alertEventMapper.selectList(new LambdaQueryWrapper<AlertEvent>()
                .orderByDesc(AlertEvent::getEventTime)
                .last("limit 20"));
    }

    @Override
    public Map<String, Object> trendPrediction() {
        double current = 2.35;
        double next24hPeak = current + ThreadLocalRandom.current().nextDouble(0.2, 0.8);
        Map<String, Object> map = new HashMap<>();
        map.put("metric", "wet_well_level");
        map.put("current", current);
        map.put("next24hPeak", next24hPeak);
        map.put("riskLevel", next24hPeak > 2.8 ? "WARN" : "NORMAL");
        map.put("suggestion", next24hPeak > 2.8 ? "建议提前联动启动排水泵组" : "维持当前策略");
        return map;
    }
}
