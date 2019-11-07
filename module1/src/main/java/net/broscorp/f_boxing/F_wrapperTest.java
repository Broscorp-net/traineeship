import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class F_wrapperTest {

  /**
   * In this test I compare two Integer Objects, which is allocated
   * in different heap area places. Test will show us falls.
   * But this is not works for numbers lass than 128. 
   */
  @Test
  void testEquality() {
    F_wrapper wrapp = new F_wrapper();
    assertTrue(wrapp.equality(500, 500));
  }
/**
 * To establish this test, I have made Autoboxing on int primitive inside
 * the method, and got check it on relation with Integer class by
 *  "instanceOf" key word. Test passed.
 */
  @Test
  void testIsItIntegerObject() {
    F_wrapper wrapp = new F_wrapper();
    assertTrue(wrapp.isItIntegerObject(1));
  }
  
  /**
   * Through this Test I have made Autoboxing on primitive, inside the method 
   * Unboxing on same argument was commit. Further I compare local Integer object
   * with primitive after Unboxing and got equality, what proves Unboxing.
   * Test passed. 
   */
  @Test
  void testIsItIntegerPrimitive() {
    F_wrapper wrapp = new F_wrapper();
    assertTrue(wrapp.isItIntegerPrimitive(new Integer(1000)));
  }

}
