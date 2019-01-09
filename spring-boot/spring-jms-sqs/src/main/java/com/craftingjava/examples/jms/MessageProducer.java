package com.craftingjava.examples.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lcsontos on 8/4/17.
 */
@RestController
@Slf4j
public class MessageProducer {

  private final JmsOperations jmsTemplate;

  @Autowired
  public MessageProducer(JmsOperations jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  @PostMapping("/message")
  public ResponseEntity sendMessage(@RequestBody String message) {
    log.info("Sending message {}.", message);
    jmsTemplate.convertAndSend(message);
    return ResponseEntity.ok().build();
  }

}
