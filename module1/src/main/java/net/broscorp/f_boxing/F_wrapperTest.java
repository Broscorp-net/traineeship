import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class F_wrapperTest {

  /**
   * In this test I compare two Integer Objects, which is allocated
   * in different heap area places. Test will show us falls.
   * But this is not works for numbers less than 128. 
   */
  @Test
  void testEquality() {
   assertTrue(equality(500, 500));
  }
  
  /**
    I got used method Overloading for this test. Methods are signed with static modifiers inside Test class.
   */
  @Test
  void testIsItIntegerPrimitive() {
    String[] probability = {"primitive", "object"};
 assertEquals(probability[1], intPrimitiveOrObject(Integer.valueOf(20)));
  }
  
  
  public static String intPrimitiveOrObject(int a) {
    return "primitive";
}

  public static String intPrimitiveOrObject (Integer e) {
     return "object";
}

  public  boolean equality(Integer a, Integer b) {
      return (a==b);
}


}
