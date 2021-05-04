package net.broscorp.gc;

public class Person {

  /**
   * Person is another person.
   */
  private Person person;

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.printf("Object" + this.toString() + "deleted by GC\n");
    super.finalize();
  }
}
