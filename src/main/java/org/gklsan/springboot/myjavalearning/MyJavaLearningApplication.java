package org.gklsan.springboot.myjavalearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "org.gklsan.springboot.util",
                "org.gklsan.springboot.myjavalearning"
        }
)
public class MyJavaLearningApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyJavaLearningApplication.class, args);
  }

}
