package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class ExceptionTest {

  //  In this test try-with-resources tries to open a non-existent file
  //  and gets a FileNotFoundException. But in the catch block its
  //  ancestor is handled - IOException.
  @Test
  @Order(1)
  public void throwsAndCatchesIoexceptionByTryWithResourcesTest() {
    System.out.println("Test 1");
    try (InputStream in = new FileInputStream("missingFileName")) {
      System.out.println(in);
    } catch (IOException ioe) {
      System.out.printf("The %s which is a descendant of IOException is caught here!%n",
          ioe.getClass().getSimpleName());
      assertTrue(ioe instanceof IOException);
    } finally {
      System.out.println("Bye and good luck!");
    }
  }

  //  In this test, the same exception is thrown along the inheritance chain from parents
  //  to children. Each link in the chain of inheritance is intercepted and checked
  //  by "assertTrue" for "instanceof" and a greeting from it is printed to the console.
  @Test
  @Order(2)
  public void throwsAndCatchesExceptionByChainOfInheritanceTest() {
    System.out.println("Test 2");
    String randomUuidString = UUID.randomUUID().toString();
    String randomString = randomUuidString
        .substring(new Random().nextInt(randomUuidString.length()));
    Exception ex = assertThrows(StringIndexOutOfBoundsException.class, () -> {
      try {
        randomString.charAt(randomString.length());
      } catch (Throwable t) {
        try {
          assertTrue(t instanceof Throwable);
          System.out.println("Hi from caught Throwable!");
          throw t;
        } catch (Exception e) {
          try {
            assertTrue(e instanceof Exception);
            System.out.println("Hi from caught Exception!");
            throw e;
          } catch (RuntimeException rte) {
            try {
              assertTrue(rte instanceof RuntimeException);
              System.out.println("Hi from caught RuntimeException!");
              throw rte;
            } catch (IndexOutOfBoundsException ioobe) {
              assertTrue(ioobe instanceof IndexOutOfBoundsException);
              System.out.println("Hi from caught IndexOutOfBoundsException!");
              throw ioobe;
            }
          }
        }
      }
    }, "We expect the code under test to throw, but it didn't");
    System.out.printf("Hi from caught %s!%n", ex.getClass().getSimpleName());
  }
}
