package com.pump.ai.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InspectionScheduler {

    @Scheduled(cron = "0 0/30 * * * ?")
    public void routineInspectionTrigger() {
        log.info("触发例行巡检计划任务（每30分钟检查一次）");
    }
}
