package net.broscorp.equals.hashcode;

public class Country {

  private String name;
  private Integer gdp;
  private Integer populace;
  private Boolean euMember;

  /**
   * This class is supposed to be representing a country.
   */
  public Country(String name, Integer gdp, Integer populace, Boolean euMember) {
    this.name = name;
    this.gdp = gdp;
    this.populace = populace;
    this.euMember = euMember;
  }

  public String getName() {
    return name;
  }

  public Integer getGdp() {
    return gdp;
  }

  public Integer getPopulace() {
    return populace;
  }

  public Boolean getEuMember() {
    return euMember;
  }

  public String toString() {
    String membership = euMember ? "is a EU member" : "not a EU member";
    return name + gdp.toString() + populace.toString() + membership;
  }

  /**
   * The java.net.broscorp.equals method implements an equivalence relation on non-null object
   * references: It is reflexive: for any non-null reference value x, x.java.net.broscorp.equals(x)
   * should return true. It is symmetric: for any non-null reference values x and y,
   * x.java.net.broscorp.equals(y) should return true if and only if y.java.net.broscorp.equals(x)
   * returns true. It is transitive: for any non-null reference values x, y, and z, if
   * x.java.net.broscorp.equals(y) returns true and y.java.net.broscorp.equals(z) returns true, then
   * x.java.net.broscorp.equals(z) should return true. It is consistent: for any non-null reference
   * values x and y, multiple invocations of x.java.net.broscorp.equals(y) consistently return true
   * or consistently return false, provided no information used in java.net.broscorp.equals
   * comparisons on the objects is modified. For any non-null reference value x,
   * x.java.net.broscorp.equals(null) should return false.
   */
  public boolean equals(Object someCountry) {
    if (this == someCountry) {
      return true;
    }
    if (someCountry == null) {
      return false;
    }
    if (getClass() != someCountry.getClass()) {
      return false;
    }
    Country country = (Country) someCountry;
    return (name.equals(country.getName()) && gdp.equals(country.getGdp()) && populace
        .equals(country.getPopulace()) && euMember == country.getEuMember());
  }

  public int hashCode() {
    return name.hashCode() * gdp * populace * euMember.hashCode();
  }
}