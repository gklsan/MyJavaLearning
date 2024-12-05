package org.gklsan.springboot.myjavalearning.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FootballCoach implements Coach {

  @Override
  public String getCoachName() {
      System.out.println("In constructor: " + getClass().getSimpleName());
      return "Football Coach :=) -";
  }

  @PostConstruct
  public void doMyStartupStuff() {
      System.out.println("FootballCoach: inside method doMyStartupStuff: " + getClass().getSimpleName());
  }

  @PreDestroy
  public void doMyCleanupStuff() {
      System.out.println("FootballCoach: inside method doMyCleanupStuff: " + getClass().getSimpleName());
  }

}
