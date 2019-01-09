package com.craftingjava.examples.jms.sqs;

import javax.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lcsontos on 8/4/17.
 */
@Configuration
public class ExtendedSqsConfiguration extends AbstractSqsConfiguration {

  @Bean
  @Override
  public ConnectionFactory connectionFactory(SqsProperties sqsProperties) {
    return createExtendedSQSConnectionFactory(sqsProperties);
  }

}
