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
  private Coach myAnotherCoach;

  @Autowired
  public FirstJavaController(
          @Qualifier("footballCoach") Coach theCoach,
          @Qualifier("footballCoach") Coach theAnotherCoach) {
    myCoach = theCoach;
    myAnotherCoach = theAnotherCoach;
  }

  @GetMapping("/myname")
  public String getServerName() {
    return myName;
  }

  @GetMapping("/get-coach-name")
  public String getCoachName() {
      return myCoach.getCoachName();
  }

  @GetMapping("/check-bean")
  public String checkBean() {
    System.out.println("Current controller: " + getClass().getSimpleName());
    return "Is coach same: " + (myCoach == myAnotherCoach);
  }

}
