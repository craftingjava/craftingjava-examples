package com.springuni.examples.kubernetes;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegistrationController {

  private final Registration registration;

  @GetMapping("/me")
  public Map<String, Object> getLocalServiceInstance() {
    return Map.of(
        "serviceId", registration.getServiceId(),
        "host", registration.getHost(),
        "uri", registration.getUri()
    );
  }

}
