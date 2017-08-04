package com.springuni.examples.jms.sqs;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import org.springframework.jms.support.destination.DestinationResolver;

/**
 * Created by lcsontos on 8/4/17.
 */
public class SqsDestinationResolver implements DestinationResolver {

  private final String queueName;

  public SqsDestinationResolver(String queueName) {
    this.queueName = queueName;
  }

  @Override
  public Destination resolveDestinationName(
      Session session, String destinationName, boolean pubSubDomain) throws JMSException {

    return session.createQueue(queueName);
  }

}
