package com.example.sampleasync;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@SpringBootApplication
public class SampleAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAsyncApplication.class, args);
	}

	@Bean
    @Qualifier("heavyTaskExecutor")
    public TaskExecutor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(1);
	    executor.setMaxPoolSize(2);
	    executor.setQueueCapacity(2);
	    return executor;
    }
}
