package org.gklsan.springboot.myjavalearning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.gklsan.springboot.crud",
                "org.gklsan.springboot.myjavalearning"
        }
)

//@SpringBootApplication
public class MyJavaLearningApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyJavaLearningApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(String[] args) {
    return runner -> {
      System.out.println("Hello World");
    };
  }

}
