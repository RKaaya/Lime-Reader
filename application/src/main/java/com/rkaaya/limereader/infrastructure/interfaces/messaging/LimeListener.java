package com.rkaaya.limereader.infrastructure.interfaces.messaging;

import com.rkaaya.lime.domain.model.Lime;
import com.rkaaya.limereader.api.LimeReaderService;
import com.rkaaya.limereader.api.messaging.ApiChannel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@AllArgsConstructor
public class LimeListener {

    private LimeReaderService limeReaderService;

    @StreamListener(ApiChannel.INPUT)
    public void handleLime(@Payload Message<Lime> lime) {
        log.info("Received message: {}", lime);
        limeReaderService.saveLimeMessage(lime.getPayload(), lime.getHeaders().get("kafka_receivedTimestamp", Long.class));
        lime.getHeaders().getTimestamp();
    }
}
