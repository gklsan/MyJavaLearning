package org.gklsan.springboot.myjavalearning.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {

  @Override
    public String getCoachName() {
        return "Cricket Coach 1";
    }
}
