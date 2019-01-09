package com.craftingjava.examples.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by lcsontos on 8/4/17.
 */
@Component
@Slf4j
public class MessageConsumer {

  @JmsListener(destination = "")
  public void receive(@Payload String message) {
    log.info("Received message {}.", message);
  }

}
