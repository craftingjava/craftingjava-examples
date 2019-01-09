package com.craftingjava.examples.pubsub.publisher;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

  private final MessageChannel outgoing;

  public PublisherController(Channels channels) {
    outgoing = channels.outgoing();
  }

  @PostMapping("/publish/{name}")
  public void publish(@PathVariable String name) {
    outgoing.send(MessageBuilder.withPayload("Hello " + name + "!").build());
  }

}
