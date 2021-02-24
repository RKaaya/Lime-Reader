package com.rkaaya.limereader.configuration;

import com.rkaaya.limereader.api.LimeReaderService;
import com.rkaaya.limereader.api.messaging.ApiChannel;
import com.rkaaya.limereader.infrastructure.interfaces.messaging.LimeListener;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableBinding(ApiChannel.class)
public class EventConsumerConfiguration {

    @Bean
    public LimeListener limeListener(final LimeReaderService limeReaderService) {
        return new LimeListener(limeReaderService);
    }
}
