package com.pump.ai.service;

import com.pump.ai.dto.ControlActionRequest;
import com.pump.ai.dto.DefenseActionRequest;
import com.pump.ai.dto.InspectionStartRequest;
import com.pump.ai.entity.AlertEvent;
import com.pump.ai.entity.InspectionTask;

import java.util.List;
import java.util.Map;

public interface PatrolService {
    InspectionTask startInspection(InspectionStartRequest request);

    Map<String, Object> doDefenseAction(DefenseActionRequest request);

    Map<String, Object> controlDevice(ControlActionRequest request);

    List<AlertEvent> latestAlerts();

    Map<String, Object> trendPrediction();
}
