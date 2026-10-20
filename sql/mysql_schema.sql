CREATE DATABASE IF NOT EXISTS ai_patrol DEFAULT CHARACTER SET utf8mb4;
USE ai_patrol;

CREATE TABLE IF NOT EXISTS inspection_task (
  id BIGINT PRIMARY KEY,
  mode VARCHAR(32) NOT NULL COMMENT 'ACTIVE/FULL/ROUTINE/WEATHER',
  route_code VARCHAR(64) NOT NULL,
  status VARCHAR(32) NOT NULL,
  plan_start_time DATETIME,
  plan_end_time DATETIME,
  points_total INT DEFAULT 0,
  abnormal_count INT DEFAULT 0,
  report_url VARCHAR(255),
  created_at DATETIME
);

CREATE TABLE IF NOT EXISTS alert_event (
  id BIGINT PRIMARY KEY,
  category VARCHAR(64) NOT NULL COMMENT '入侵/机柜故障灯/积水/安全帽/跌倒/液位超限等',
  level VARCHAR(16) NOT NULL COMMENT 'HIGH/MEDIUM/LOW',
  location VARCHAR(128),
  detail VARCHAR(500),
  process_status VARCHAR(32),
  event_time DATETIME,
  linked_control TINYINT(1) DEFAULT 0
);

CREATE TABLE IF NOT EXISTS defense_policy (
  id BIGINT PRIMARY KEY,
  policy_name VARCHAR(64) NOT NULL,
  disarm_seconds INT DEFAULT 3,
  rearm_seconds INT DEFAULT 8,
  status VARCHAR(16) DEFAULT 'ENABLED',
  zones_json TEXT
);

CREATE TABLE IF NOT EXISTS control_rule (
  id BIGINT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  trigger_type VARCHAR(32) NOT NULL COMMENT 'TEMP/HUMIDITY/WATER_LEVEL/TIME/WATER_LEAK',
  expression VARCHAR(255) NOT NULL,
  device_code VARCHAR(64) NOT NULL,
  action VARCHAR(32) NOT NULL,
  priority INT DEFAULT 0,
  enabled TINYINT(1) DEFAULT 1
);

CREATE TABLE IF NOT EXISTS recognition_event (
  id BIGINT PRIMARY KEY,
  scene_type VARCHAR(64) NOT NULL,
  target VARCHAR(128) NOT NULL,
  confidence DECIMAL(6,4) DEFAULT 0,
  image_url VARCHAR(255),
  result VARCHAR(64),
  camera_code VARCHAR(64),
  captured_at DATETIME
);
