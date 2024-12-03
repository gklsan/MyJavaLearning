package org.gklsan.springboot.myjavalearning.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

  @Override
  public String getCoachName() {
      return "Football Coach 1";
  }

}
