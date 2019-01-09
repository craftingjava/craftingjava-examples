package com.craftingjava.examples.pubsub.subscriber;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(Sink.class)
@SpringBootApplication
public class PubsubSubscriberApplication {

  public static void main(String[] args) {
    SpringApplication.run(PubsubSubscriberApplication.class, args);
  }

  @StreamListener(Sink.INPUT)
  public void handleMessage(Message<String> message) {
    log.info("Received: {}.", message.getPayload());
  }

}
