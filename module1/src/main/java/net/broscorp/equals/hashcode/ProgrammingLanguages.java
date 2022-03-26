package net.broscorp.equals.hashcode;

public class ProgrammingLanguages {

  String nameOfProgLanguage;
  Integer yearOfDevelopmentOfThisLanguage;

  public ProgrammingLanguages(String nameOfProgrammingLanguage,
                              Integer yearOfDevelopmentOfThisLanguage) {
    this.nameOfProgLanguage = nameOfProgrammingLanguage;
    this.yearOfDevelopmentOfThisLanguage = yearOfDevelopmentOfThisLanguage;
  }

  public String getNameOfProgrLanguage() {
    return nameOfProgLanguage;
  }

  public void setNameOfProgrLanguage(String nameOfProgLanguage) {
    this.nameOfProgLanguage = nameOfProgLanguage;
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
    return programmingLanguages.getNameOfProgrLanguage()
                == this.getNameOfProgrLanguage()
                && programmingLanguages.getYearOfDevelopmentOfThisLanguage()
                == this.getYearOfDevelopmentOfThisLanguage();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + (nameOfProgLanguage
            == null ? 0 : nameOfProgLanguage.hashCode());
    hash = 31 * hash + (yearOfDevelopmentOfThisLanguage
            == null ? 0 : yearOfDevelopmentOfThisLanguage.hashCode());
    return hash;
  }

  @Override
  public String toString() {
    return "Programming Language:"
            + "\nname of Programming Language: "
            + nameOfProgLanguage
            + ", date of creation of Programming Language: "
            + yearOfDevelopmentOfThisLanguage;
  }
}
