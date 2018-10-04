package com.springuni.examples.twitter;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Slf4j
@Configuration
public class TwitterConfig {

  @Bean
  TwitterStreamFactory twitterStreamFactory() {
    return new TwitterStreamFactory();
  }

  @Bean
  TwitterStream twitterStream(TwitterStreamFactory twitterStreamFactory) {
    return twitterStreamFactory.getInstance();
  }

  @Bean
  MessageChannel outputChannel() {
    return MessageChannels.direct().get();
  }

  @Bean
  TwitterMessageProducer twitterMessageProducer(
      TwitterStream twitterStream, MessageChannel outputChannel) {

    TwitterMessageProducer twitterMessageProducer =
        new TwitterMessageProducer(twitterStream, outputChannel);

    twitterMessageProducer.setTerms(Arrays.asList("java", "microservices", "spring"));

    return twitterMessageProducer;
  }

  @Bean
  IntegrationFlow twitterFlow(MessageChannel outputChannel) {
    return IntegrationFlows.from(outputChannel)
        .transform(Status::getText)
        .handle(m -> log.info(m.getPayload().toString()))
        .get();
  }

}
