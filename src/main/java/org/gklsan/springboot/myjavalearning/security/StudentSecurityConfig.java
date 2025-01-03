package org.gklsan.springboot.myjavalearning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class StudentSecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");

    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

    return jdbcUserDetailsManager;
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
                                       .requestMatchers(HttpMethod.GET, "/api/graphql", "/graphiql").permitAll() // Allow GET for both paths
                                       .requestMatchers(HttpMethod.POST, "/api/graphql").permitAll()

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
