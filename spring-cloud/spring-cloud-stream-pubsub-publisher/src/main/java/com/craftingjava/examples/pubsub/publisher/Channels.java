package com.craftingjava.examples.pubsub.publisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {

  @Output
  MessageChannel outgoing();

}
