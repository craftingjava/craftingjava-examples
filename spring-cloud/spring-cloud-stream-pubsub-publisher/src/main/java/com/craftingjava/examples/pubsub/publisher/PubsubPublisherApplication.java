package com.craftingjava.examples.pubsub.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(Channels.class)
@SpringBootApplication
public class PubsubPublisherApplication {

  public static void main(String[] args) {
    SpringApplication.run(PubsubPublisherApplication.class, args);
  }

}
