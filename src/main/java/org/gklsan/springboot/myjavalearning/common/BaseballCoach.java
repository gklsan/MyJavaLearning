package org.gklsan.springboot.myjavalearning.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach  implements Coach{
  @Override
  public String getCoachName() {
        return "Baseball Coach";
    }
}
