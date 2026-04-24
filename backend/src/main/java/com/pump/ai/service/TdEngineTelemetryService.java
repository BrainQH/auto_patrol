package com.pump.ai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TdEngineTelemetryService {
    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> latestTelemetry(String deviceCode) {
        String sql = "SELECT ts, metric, val FROM telemetry_point WHERE device_code = ? ORDER BY ts DESC LIMIT 50";
        return jdbcTemplate.queryForList(sql, deviceCode);
    }
}
