package com.example.sampleasync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TaskService {

    @Async("heavyTaskExecutor")
    public void heavyTask() {
        try {
            log.info("start heavy task");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            log.error("Exception Occurred.", ie);
        } finally {
            log.info("end heavy task");
        }
    }

}
