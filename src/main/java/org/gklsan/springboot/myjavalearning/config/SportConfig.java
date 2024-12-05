package org.gklsan.springboot.myjavalearning.config;

import org.gklsan.springboot.myjavalearning.common.Coach;
import org.gklsan.springboot.myjavalearning.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

  @Bean("custom-bean-id")
  public Coach swimCoach() {
    return new SwimCoach();
  }
}
