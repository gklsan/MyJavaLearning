package org.gklsan.springboot.myjavalearning.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getCoachName() {
        return "Track Coach";
    }
}
