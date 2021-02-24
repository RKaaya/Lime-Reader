package com.rkaaya.limereader.runnable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication(scanBasePackages = {"com.rkaaya.limereader.configuration", "com.rkaaya.limereader.infrastructure.interfaces"})
@EnableJpaRepositories("com.rkaaya.limereader.services.dao.repository")
@EntityScan("com.rkaaya.limereader.services.dao.entity")
@EnableJpaAuditing
public class LimeReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimeReaderApplication.class, args);
    }

}
