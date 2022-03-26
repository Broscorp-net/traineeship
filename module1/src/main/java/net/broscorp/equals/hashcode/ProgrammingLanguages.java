package net.broscorp.equals.hashcode;

public class ProgrammingLanguages {

  String nameOfProgrammingLanguage;
  Integer yearOfDevelopmentOfThisLanguage;

  public ProgrammingLanguages(String nameOfProgrammingLanguage,
                              Integer yearOfDevelopmentOfThisLanguage) {
    this.nameOfProgrammingLanguage = nameOfProgrammingLanguage;
    this.yearOfDevelopmentOfThisLanguage = yearOfDevelopmentOfThisLanguage;
  }

  public String getNameOfProgrammingLanguage() {
    return nameOfProgrammingLanguage;
  }

  public void setNameOfProgrammingLanguage(String nameOfProgrammingLanguage) {
    this.nameOfProgrammingLanguage = nameOfProgrammingLanguage;
  }

  public int getYearOfDevelopmentOfThisLanguage() {
    return yearOfDevelopmentOfThisLanguage;
  }

  public void setYearOfDevelopmentOfThisLanguage(Integer yearOfDevelopmentOfThisLanguage) {
    this.yearOfDevelopmentOfThisLanguage = yearOfDevelopmentOfThisLanguage;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof ProgrammingLanguages)) {
      return false;
    }

    ProgrammingLanguages programmingLanguages
                = (ProgrammingLanguages) obj;
    return programmingLanguages.getNameOfProgrammingLanguage()
                == this.getNameOfProgrammingLanguage()
                && programmingLanguages.getYearOfDevelopmentOfThisLanguage()
                == this.getYearOfDevelopmentOfThisLanguage();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + (nameOfProgrammingLanguage
            == null ? 0 : nameOfProgrammingLanguage.hashCode());
    hash = 31 * hash + (yearOfDevelopmentOfThisLanguage
            == null ? 0 : yearOfDevelopmentOfThisLanguage.hashCode());
    return hash;
  }

  @Override
  public String toString() {
    return "Programming Language:"
            + "\nname of Programming Language: "
            + nameOfProgrammingLanguage
            + ", date of creation of Programming Language: "
            + yearOfDevelopmentOfThisLanguage;
  }
}
