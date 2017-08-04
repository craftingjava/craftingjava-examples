package com.springuni.examples.jms;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

import com.springuni.examples.jms.sqs.AbstractSqsConfiguration;
import com.springuni.examples.jms.sqs.ExtendedSqsConfiguration;
import com.springuni.examples.jms.sqs.SqsProperties;
import com.springuni.examples.jms.sqs.StandardSqsConfiguration;
import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

/**
 * Created by lcsontos on 8/4/17.
 */
@ComponentScan(
  basePackages = "com.springuni.examples.jms",
  excludeFilters = @Filter(type = ASSIGNABLE_TYPE, value = AbstractSqsConfiguration.class)
)
@Import(StandardSqsConfiguration.class)
@PropertySource(name = "dev", value = "file:.env", ignoreResourceNotFound = true)
@Slf4j
@SpringBootApplication
public class Application {

  public static void main(String[] args) throws Exception {
    log.info(new File(".").getAbsolutePath());
    SpringApplication.run(Application.class, args);
  }

}
