package org.gklsan.springboot.myjavalearning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class StudentSecurityConfig {

  @Bean
  public InMemoryUserDetailsManager uerDetailsManager() {

    UserDetails john = User.builder()
                           .username("john").password("{noop}12345")
                           .roles("STUDENT")
                           .build();
    UserDetails mary = User.builder()
                           .username("mary").password("{noop}12345")
                           .roles("TEACHER", "HOD")
                           .build();
    UserDetails joe = User.builder()
                          .username("joe").password("{noop}12345")
                          .roles("TEACHER", "HOD", "PRINCIPAL")
                          .build();

    return new InMemoryUserDetailsManager(john, mary, joe);
  }
}
