package net.broscorp.gc;

public class PersonMain {

  public static void main(String[] args) {
    for (int i = 0; i < 1000000; i++){
      Person person = new Person(i, "newName");
    }
  }
}
