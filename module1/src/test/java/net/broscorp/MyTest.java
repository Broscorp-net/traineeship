package net.broscorp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.broscorp.equals.hashcode.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MyTest {

  private final List<Person> people = new ArrayList<>(Arrays.asList(
      new Person("Vadim", 12),
      new Person("Vadim", 12),
      new Person("Vadim", 12),
      new Person("Aa", 14),
      new Person("BB", 14)
  ));

  @Test
  public void hashCodeShouldBeSameForOneObject() {
    Assertions.assertEquals(people.get(0).hashCode(), people.get(0).hashCode());
  }

  @Test
  public void ifEqualReturnTrueHashCodeShouldBeSame() {
    Person obj1 = people.get(0);
    Person obj2 = people.get(1);
    Assertions.assertEquals(obj2, obj1);
    Assertions.assertEquals(obj2.hashCode(), obj1.hashCode());
  }

  @Test
  public void hashCodeCanBeSameWhenObjectsNotEqual() {
    Person obj1 = people.get(3);
    Person obj2 = people.get(4);
    Assertions.assertNotEquals(obj2, obj1);
    Assertions.assertEquals(obj2.hashCode(), obj1.hashCode());
  }

  //It is reflexive: for any non-null reference value x, x.equals(x) should return true.
  @Test
  public void reflexive() {
    Person x = people.get(0);
    Assertions.assertEquals(x, x);
  }

  /*It is symmetric: for any non-null reference values x and y,
   x.equals(y) should return true if and only if y.equals(x) returns true. */
  @Test
  public void symmetric() {
    Person x = people.get(0);
    Person y = people.get(1);
    Assertions.assertEquals(x, y);
    Assertions.assertEquals(y, x);
  }

  /*It is transitive: for any non-null reference values x, y, and z,
   if x.equals(y) returns true and y.equals(z) returns true,
   then x.equals(z) should return true.*/
  @Test
  public void transitive() {
    Person x = people.get(0);
    Person y = people.get(1);
    Person z = people.get(2);
    Assertions.assertEquals(x, y);
    Assertions.assertEquals(y, z);
    Assertions.assertEquals(x, z);
  }

  /*It is consistent: for any non-null reference values x and y,
   multiple invocations of x.equals(y) consistently
   return true or consistently return false,
    provided no information used in equals comparisons on the objects is modified*/
  @Test
  public void consistent() {
    Person x = people.get(0);
    Person y = people.get(3);
    Assertions.assertNotEquals(x, y);
    Assertions.assertNotEquals(x, y);
  }

  //For any non-null reference value x, x.equals(null) should return false.
  @Test
  public void objNotEqualNull() {
    Person x = people.get(1);
    Assertions.assertNotEquals(x, null);
  }

  @Test
  public void findIdenticalHashCodes() {
    for (int i = 0; i < people.size(); i++) {
      for (int j = i + 1; j < people.size(); j++) {
        Person firstPerson = people.get(i);
        Person secondPerson = people.get(j);
        if (!firstPerson.equals(secondPerson)) {
          if (firstPerson.hashCode() == secondPerson.hashCode()) {
            System.out.printf("Вот объект %s, вот объект %s они разные но их хэш совпадает %d%n",
                firstPerson, secondPerson, firstPerson.hashCode());
          }
        }
      }
    }
  }
}