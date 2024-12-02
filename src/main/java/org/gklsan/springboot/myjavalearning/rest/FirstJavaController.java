package org.gklsan.springboot.myjavalearning.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstJavaController {

  @Value("${gklsan.name}")
  private String myName;

  @GetMapping("/myname")
  public String getServerName() {
    return myName;
  }

}
