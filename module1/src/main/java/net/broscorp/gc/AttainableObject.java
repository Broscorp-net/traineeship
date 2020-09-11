public class AttainableObject {
  Person person;

  public AttainableObject(Person person) {
    this.person = person;
  }

  /*@Override
  protected void finalize() throws Throwable {
    person.list.add(this);
    System.out.println("Finalize method call"); //unreachable line
    super.finalize();
  }*/
}
