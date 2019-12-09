package net.broscorp.i_equals_hashcode;



public class Worker {
  public int id;
  public String name;
  public int age;

  public Worker(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)  return true;
    if (obj == null || getClass() != obj.getClass())  return false;

    Worker worker = (Worker) obj;
    if (id != worker.id )return false;
    if (age != worker.age )return false;

    if (name == null) {
      return worker.name == null;
    } else
      return name.equals(worker.name);
  }

  @Override
  public String toString() {
    return "Worker : id=" + id + ", name=" + name + ", age=" + age;
  }
}
