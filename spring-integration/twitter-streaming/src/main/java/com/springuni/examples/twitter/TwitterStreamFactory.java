package com.springuni.examples.twitter;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import twitter4j.TwitterStream;

public class TwitterStreamFactory extends AbstractFactoryBean<TwitterStream> {

  @Override
  public Class<?> getObjectType() {
    return TwitterStream.class;
  }

  @Override
  protected TwitterStream createInstance() {
    return new twitter4j.TwitterStreamFactory().getInstance();
  }

  @Override
  protected void destroyInstance(TwitterStream twitterStream) {
    twitterStream.shutdown();
  }

}
