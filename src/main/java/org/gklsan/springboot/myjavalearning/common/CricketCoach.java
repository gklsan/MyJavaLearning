package org.gklsan.springboot.myjavalearning.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

  @Override
    public String getCoachName() {
        return "Cricket Coach 1";
    }
}
