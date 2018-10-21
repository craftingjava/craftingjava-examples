package com.springuni.examples.kubernetes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GreetingsController {

  @Value("${name}")
  private String name;

  @GetMapping("/greet")
  String greet() {
    return "Hello" + this.name;
  }

}
