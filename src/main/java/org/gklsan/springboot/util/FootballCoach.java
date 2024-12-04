package org.gklsan.springboot.util;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

  @Override
  public String getCoachName() {
      return "Football Coach :=) -";
  }

}
