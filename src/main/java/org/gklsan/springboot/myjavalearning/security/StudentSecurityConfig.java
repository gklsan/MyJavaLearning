package org.gklsan.springboot.myjavalearning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class StudentSecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    return new JdbcUserDetailsManager(dataSource);
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(authorixeRequest ->
                                   authorixeRequest.requestMatchers(HttpMethod.GET, "/api/students").hasRole("STUDENT")
                                       .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("STUDENT")
                                       .requestMatchers(HttpMethod.POST, "/api/students").hasRole("TEACHER")
                                       .requestMatchers(HttpMethod.PUT, "/api/students/**").hasRole("TEACHER")
                                       .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("PRINCIPAL")
    );

    http.authorizeHttpRequests(authorixeRequest ->
                                   authorixeRequest
                                       .requestMatchers(HttpMethod.GET, "/api/stream").permitAll()
                                       .requestMatchers(HttpMethod.GET, "/api/download").permitAll()
                                       .requestMatchers(HttpMethod.GET, "/api/downloadold").permitAll()

    );
    http.httpBasic(Customizer.withDefaults());
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }



//  @Bean
//  public InMemoryUserDetailsManager uerDetailsManager() {
//
//    UserDetails john = User.builder()
//                           .username("john").password("{noop}12345")
//                           .roles("STUDENT")
//                           .build();
//    UserDetails mary = User.builder()
//                           .username("mary").password("{noop}12345")
//                           .roles("TEACHER", "STUDENT")
//                           .build();
//    UserDetails joe = User.builder()
//                          .username("joe").password("{noop}12345")
//                          .roles("TEACHER", "STUDENT", "PRINCIPAL")
//                          .build();
//
//    return new InMemoryUserDetailsManager(john, mary, joe);
//  }
}
