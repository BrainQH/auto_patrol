CREATE DATABASE IF NOT EXISTS ai_patrol_ts;
USE ai_patrol_ts;

CREATE STABLE IF NOT EXISTS telemetry_point (
  ts TIMESTAMP,
  metric NCHAR(64),
  val DOUBLE,
  quality INT
) TAGS (
  station_code NCHAR(32),
  device_code NCHAR(64)
);

CREATE TABLE IF NOT EXISTS d_pump_01 USING telemetry_point TAGS ('PS-001', 'PUMP-01');
CREATE TABLE IF NOT EXISTS d_level_01 USING telemetry_point TAGS ('PS-001', 'LEVEL-01');
