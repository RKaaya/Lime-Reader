package com.rkaaya.limereader.api.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ApiChannel {
    String INPUT = "limte-text-in";

    @Input(INPUT)
    SubscribableChannel inboundGreetings();
}
