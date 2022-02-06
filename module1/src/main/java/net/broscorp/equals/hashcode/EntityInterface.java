package net.broscorp.equals.hashcode;

public interface EntityInterface {
  void setName(String name);

  String getName();

  void setSurname(String surname);

  String getSurname();

  void setAge(int age);

  int getAge();

  int hashCode();

  String toString();

  boolean equals(Object object);
}
