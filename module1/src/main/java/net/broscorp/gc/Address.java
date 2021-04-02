package net.broscorp.gc;

public class Address {
  private String address;
  private Person person;

  public Address(String address) {
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  protected void finalize()  {
    System.out.println("*");
  }
}
