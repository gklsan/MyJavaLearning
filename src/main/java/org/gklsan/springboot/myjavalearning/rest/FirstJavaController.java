package org.gklsan.springboot.myjavalearning.rest;

import org.gklsan.springboot.myjavalearning.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstJavaController {

  @Value("${gklsan.name}")
  private String myName;

  private Coach myCoach;

  @Autowired
  public FirstJavaController(@Qualifier("custom-bean-id") Coach theCoach) {
    System.out.println("In constructor: " + getClass().getSimpleName());
    myCoach = theCoach;
  }

  @GetMapping("/myname")
  public String getServerName() {
    return myName;
  }

    @GetMapping("/get-coach-name")
  public String getCoachName() {
      return myCoach.getCoachName();
  }

}
