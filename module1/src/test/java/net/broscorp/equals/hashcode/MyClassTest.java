package net.broscorp.equals.hashcode;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyClassTest {

  private static final int intField = 3;
  private static final String stringField = "three";
  private static final List<MyClass> myClassList = new ArrayList<>();

  @BeforeAll
  static void init() {
    for (int i = 0; i < 7; i++) {
      myClassList.add(new MyClass(i, String.valueOf(i)));
    }
  }

  //  The equals method is reflexive: for any non-null reference value x, x.equals(x) should return
  //  true.
  @Test
  public void shouldReturnTrueForSelfComparingNonNullReferenceValueTest() {
    //    GIVEN
    int randomIndex = new Random().nextInt(7);
    MyClass x = myClassList.get(randomIndex);
    //    THEN
    Assertions.assertTrue(x.equals(myClassList.get(randomIndex)));
    Assertions.assertTrue(x.equals(x));
  }

  //  The equals method is symmetric: for any non-null reference values x and y, x.equals(y) should
  //  return true if and only if y.equals(x) returns true.
  @Test
  public void shouldReturnTrueForSymmetricalComparingTest() throws InterruptedException {
    //    GIVEN
    Date dateField1 = new Date();
    MyClass myClassInstanceX = new MyClass(intField, stringField, dateField1);
    MyClass myClassInstanceY = new MyClass(intField, stringField, dateField1);
    Thread.sleep(100);
    Date dateField2 = new Date();
    MyClass myClassInstanceZ = new MyClass(intField, stringField, dateField2);
    //    THEN
    Assertions.assertTrue(myClassInstanceX.equals(myClassInstanceY));
    Assertions.assertTrue(myClassInstanceY.equals(myClassInstanceX));
    Assertions.assertFalse(myClassInstanceX.equals(myClassInstanceZ));
    Assertions.assertFalse(myClassInstanceZ.equals(myClassInstanceX));
  }

  //  The equals method is transitive: for any non-null reference values x, y, and z, if
  //  x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
  @Test
  public void shouldReturnTrueForTransitiveComparingTest() {
    //    GIVEN
    Date dateField = new Date();
    MyClass myClassInstanceX = new MyClass(intField, stringField, dateField);
    MyClass myClassInstanceY = new MyClass(intField, stringField, dateField);
    MyClass myClassInstanceZ = new MyClass(intField, stringField, dateField);
    //    THEN
    Assertions.assertTrue(myClassInstanceX.equals(myClassInstanceY));
    Assertions.assertTrue(myClassInstanceY.equals(myClassInstanceZ));
    Assertions.assertTrue(myClassInstanceX.equals(myClassInstanceZ));
  }

  //  The equals method is consistent: for any non-null reference values x and y, multiple
  //  invocations of x.equals(y) consistently return true or consistently return false, provided no
  //  information used in equals comparisons on the objects is modified.
  @Test
  public void shouldReturnPersistentComparisonResultTest() throws InterruptedException {
    //    GIVEN
    Date dateField1 = new Date();
    MyClass myClassInstanceX = new MyClass(intField, stringField, dateField1);
    MyClass myClassInstanceY = new MyClass(intField, stringField, dateField1);
    Thread.sleep(100);
    Date dateField2 = new Date();
    MyClass myClassInstanceZ = new MyClass(intField, stringField, dateField2);
    //    THEN
    for (int i = 0; i < 10; i++) {
      Assertions.assertTrue(myClassInstanceX.equals(myClassInstanceY));
      Assertions.assertFalse(myClassInstanceX.equals(myClassInstanceZ));
    }
  }

  //  The equals method for any non-null reference value x, x.equals(null) should return false.
  @Test
  public void shouldReturnFalseForComparisonWithNullTest() {
    for (MyClass myClassInstance : myClassList) {
      Assertions.assertFalse(myClassInstance.equals(null));
    }
  }

  //  Whenever it is invoked on the same object more than once during an
  //  execution of a Java application, the hashCode method must consistently return the same
  //  integer, provided no information used in equals comparisons on the object is modified.
  //  This integer need not remain consistent from one execution of an application to another
  //  execution of the same application.
  @Test
  public void shouldConsistentlyReturnSameHashCodeTest() {
    //    GIVEN
    Date dateField = new Date();
    MyClass myClassInstance = new MyClass(intField, stringField, dateField);
    int etalonHashCodeValue = myClassInstance.hashCode();
    //    THEN
    for (int i = 0; i < 10; i++) {
      Assertions.assertEquals(etalonHashCodeValue, myClassInstance.hashCode());
    }
  }

  //  If two objects are equal according to the equals(Object) method, then calling the hashCode
  //  method on each of the two objects must produce the same integer result.
  @Test
  public void shouldReturnSameHashCodeForEqualObjectsTest() {
    //    GIVEN
    Date dateField = new Date();
    MyClass etalonMyClassInstance = new MyClass(intField, stringField, dateField);
    int etalonHashCodeValue = etalonMyClassInstance.hashCode();
    //    THEN
    for (int i = 0; i < 10; i++) {
      MyClass tempMyClassInstance = new MyClass(intField, stringField, dateField);
      Assertions.assertEquals(etalonMyClassInstance, tempMyClassInstance);
      Assertions.assertEquals(etalonHashCodeValue, tempMyClassInstance.hashCode());
    }
  }

  //  It is not required that if two objects are unequal according to the equals(Object) method,
  //  then calling the hashCode method on each of the two objects must produce distinct integer
  //  results. However, the programmer should be aware that producing distinct integer results for
  //  unequal objects may improve the performance of hash tables.
  @Test
  public void shouldFindAndPrintOutUnequalObjectsWithSameHashCodesTest() {
    Map<Integer, List<MyClass>> hashCodeMap =
        myClassList.stream()
            .collect(
                HashMap::new,
                (hm, e) -> {
                  List<MyClass> tempList = hm.get(e.hashCode());
                  if (tempList == null) {
                    tempList = new ArrayList<>();
                    tempList.add(e);
                    hm.put(e.hashCode(), tempList);
                  } else {
                    tempList.add(e);
                    hm.put(e.hashCode(), tempList);
                  }
                },
                HashMap::putAll);
    List<MyClass> oneListFromHashCodeMap = new ArrayList<>(hashCodeMap.values().iterator().next());
    for (char c = 'A'; c < 'A' + oneListFromHashCodeMap.size(); c++) {
      System.out.println(
          "Here is object "
              + c
              + ": "
              + oneListFromHashCodeMap.get(c - 'A')
              + ", it's hashcode = "
              + oneListFromHashCodeMap.get(c - 'A').hashCode()
              + ";");
    }
    System.out.println("These objects are different, but their hash codes matches");
  }
}
