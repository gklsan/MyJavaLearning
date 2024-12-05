package org.gklsan.springboot.myjavalearning.common;

public class SwimCoach implements Coach{

  public SwimCoach() {
    System.out.println("In constructor: " + getClass().getSimpleName());
  }

  @Override
  public String getCoachName() {
    return "Swim Coach";
  }
}
