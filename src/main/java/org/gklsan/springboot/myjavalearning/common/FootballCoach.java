package org.gklsan.springboot.myjavalearning.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

  @Override
  public String getCoachName() {
      return "Football Coach :=) -";
  }

}
