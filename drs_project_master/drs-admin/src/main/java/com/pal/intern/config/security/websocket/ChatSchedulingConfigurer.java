package com.pal.intern.config.security.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ChatSchedulingConfigurer implements SchedulingConfigurer {

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Bean
    public ActiveUserPinger activeUserPinger() {
        return new ActiveUserPinger();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler());
    }
}
