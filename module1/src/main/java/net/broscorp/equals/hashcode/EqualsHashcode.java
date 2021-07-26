package net.broscorp.equals.hashcode;

import java.util.Objects;

public class EqualsHashcode {

  String teamName;
  int teamSize;

  public EqualsHashcode(String teamName, int teamSize) {
    this.teamName = teamName;
    this.teamSize = teamSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EqualsHashcode)) {
      return false;
    }
    EqualsHashcode that = (EqualsHashcode) o;
    return teamSize == that.teamSize
        && Objects.equals(teamName, that.teamName);
  }

  @Override
  public int hashCode() {
    return teamSize % 48;
  }

  @Override
  public String toString() {
    return "team name = " + teamName
        + ", team size = " + teamSize;
  }

  public int getTeamSize() {
    return teamSize;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamSize(int teamSize) {
    this.teamSize = teamSize;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }
}
