package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Developer {

  private String name;

  private String specialization;

  private int yearsOfExperience;

  /**
   * Constructor for class Developer.
   * @param name  developer's first name
   * @param specialization  developer's main specialization
   * @param yearsOfExperience  developer's experience in years
   */
  public Developer(String name, String specialization, int yearsOfExperience) {
    this.name = name;
    this.specialization = specialization;
    this.yearsOfExperience = yearsOfExperience;
  }

  @Override
  public boolean equals(Object o) {
    // Check this and o refer to the same object
    if (this == o) {
      return true;
    }

    // Check o is Developer and not null
    if (!(o instanceof Developer)) {
      return false;
    }

    Developer developer = (Developer) o;

    // Compare all required fields
    return yearsOfExperience == developer.yearsOfExperience
        && Objects.equals(name, developer.name)
        && Objects.equals(specialization, developer.specialization);
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(yearsOfExperience);
    result = 31 * result + (name == null ? 0 : name.hashCode());
    result = 31 * result + (specialization == null ? 0 : specialization.hashCode());

    return result;
  }

  @Override
  public String toString() {
    return "Developer{"
        + "name='" + name + '\''
        + ", specialization='" + specialization + '\''
        + ", yearsOfExperience=" + yearsOfExperience
        + '}';
  }
}
