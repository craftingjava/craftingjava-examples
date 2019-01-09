package com.craftingjava.examples.jms.sqs;

import java.net.URI;
import java.util.Optional;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lcsontos on 8/4/17.
 */
@Data
@ConfigurationProperties(prefix = "amazon.sqs")
public class SqsProperties {

  private String region;
  private String endpoint;
  private String accessKey;
  private String secretKey;

  private Integer numberOfMessagesToPrefetch;

  private Extended extended = new Extended();

  public Optional<Integer> getNumberOfMessagesToPrefetch() {
    return Optional.ofNullable(numberOfMessagesToPrefetch);
  }

  public String getQueueName() {
    URI endpointUri = URI.create(endpoint);
    String path = endpointUri.getPath();
    int pos = path.lastIndexOf('/');
    return path.substring(pos + 1);
  }

  @Data
  public static class Extended {

    private String s3Region;
    private String s3BucketName;
    private String s3AccessKey;
    private String s3SecretKey;

  }

}
