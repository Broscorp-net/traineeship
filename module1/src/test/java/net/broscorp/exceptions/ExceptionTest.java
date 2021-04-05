package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

  //  This test throws random exceptions that are caught by the appropriate handlers.
  //  Handlers for child exceptions must be in the chain of handlers earlier than
  //  the handlers for their ancestors, otherwise will be compile error.
  @Test
  @Order(3)
  public void throwsRandomExceptionsThatCaughtByAppropriateHandlersTest() {
    System.out.println("Test 3");
    try {
      switch (new Random().nextInt(4)) {
        case 0:
          throw new Throwable();
        case 1:
          throw new Exception();
        case 2:
          throw new FileNotFoundException();
        case 3:
          throw new IndexOutOfBoundsException();
        default:
          throw new StringIndexOutOfBoundsException();
      }
    } catch (StringIndexOutOfBoundsException sioobe) {
      assertTrue(sioobe instanceof Throwable);
      assertTrue(sioobe instanceof Exception);
      assertTrue(sioobe instanceof IndexOutOfBoundsException);
      assertEquals(StringIndexOutOfBoundsException.class, sioobe.getClass());
      System.out.println("StringIndexOutOfBoundsException is subclass of Throwable, Exception"
          + " and IndexOutOfBoundsException." + System.lineSeparator()
          + "But it is caught in 'catch' for StringIndexOutOfBoundsException as a special handler"
          + " for this exception class" + System.lineSeparator()
          + "which is earlier in code than handlers for its superclasses.");
    } catch (FileNotFoundException | IndexOutOfBoundsException ex) {
      assertTrue(ex instanceof Throwable);
      assertTrue(ex instanceof Exception);
      assertTrue(ex.getClass().equals(FileNotFoundException.class)
          || ex.getClass().equals(IndexOutOfBoundsException.class));
      System.out.printf("%s is subclass of Throwable and Exception." + System.lineSeparator()
              + "But it is caught in 'catch' for FileNotFoundException" + System.lineSeparator()
              + "or IndexOutOfBoundsException as a special handler" + System.lineSeparator()
              + "for these exception classes which is earlier in code" + System.lineSeparator()
              + "than handlers for its superclasses." + System.lineSeparator(),
          ex.getClass().getSimpleName());
    } catch (Exception ex) {
      assertTrue(ex instanceof Throwable);
      assertEquals(ex.getClass(), Exception.class);
      System.out.println("Exception is subclass of Throwable" + System.lineSeparator()
          + "and the superclass for all exception classes." + System.lineSeparator()
          + "It is caught in 'catch' for Exception as a special" + System.lineSeparator()
          + "handler for this class because we have not defined" + System.lineSeparator()
          + "a narrower subclass for this exception and it is earlier" + System.lineSeparator()
          + "in code than handler for its superclass.");
    } catch (Throwable t) {
      assertTrue(t instanceof Throwable);
      assertEquals(t.getClass(), Throwable.class);
      System.out.println(
          "Throwable is the root class for all exceptions and errors." + System.lineSeparator()
              + "It is caught in 'catch' for Throwable because" + System.lineSeparator()
              + "we have not defined a narrower subclass" + System.lineSeparator()
              + "for this exception.This handler is at the very end" + System.lineSeparator()
              + "of the chain of handlers to catch absolutely all exceptions and errors.");
    }
  }

  //  This test throws random exceptions that are caught by their ancestor handlers.
  @Test
  @Order(4)
  public void throwsRandomExceptionsThatCaughtByAncestorsHandlersTest() {
    System.out.println("Test 4");
    try {
      switch (new Random().nextInt(2)) {
        case 0:
          throw new FileNotFoundException();
        case 1:
          throw new StringIndexOutOfBoundsException();
        default:
          throw new OutOfMemoryError();
      }
    } catch (IndexOutOfBoundsException ioobe) {
      assertTrue(ioobe instanceof IndexOutOfBoundsException);
      assertEquals(ioobe.getClass(), StringIndexOutOfBoundsException.class);
      System.out.printf("%s is subclass of IndexOutOfBoundsException." + System.lineSeparator()
              + "It is caught by 'catch' for IndexOutOfBoundsException" + System.lineSeparator()
              + "because there is no special handler for %s.", ioobe.getClass().getSimpleName(),
          ioobe.getClass().getSimpleName());
    } catch (IOException ioe) {
      assertTrue(ioe instanceof IOException);
      assertEquals(ioe.getClass(), FileNotFoundException.class);
      System.out.printf("%s is subclass of IOException." + System.lineSeparator()
              + "It is caught by 'catch' for IOException because" + System.lineSeparator()
              + "there is no special handler for %s.", ioe.getClass().getSimpleName(),
          ioe.getClass().getSimpleName());
    } catch (Throwable t) {
      assertTrue(t instanceof Throwable);
      assertTrue(t instanceof Error);
      assertEquals(t.getClass(), OutOfMemoryError.class);
      System.out.printf(
          "Throwable is the root class for all exceptions and errors." + System.lineSeparator()
              + "%s is caught in 'catch' for Throwable because" + System.lineSeparator()
              + "there is no special 'catch' for such subclass of Throwable in code.",
          t.getClass().getSimpleName());
    }
  }
}
