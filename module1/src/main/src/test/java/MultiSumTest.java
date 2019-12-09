import static org.junit.jupiter.api.Assertions.assertEquals;

import net.broscorp.m_override_overload.MathOperation;
import net.broscorp.m_override_overload.MultiEx;
import net.broscorp.m_override_overload.SumEx;
import org.junit.jupiter.api.Test;

public class MultiSumTest {
  @Test
  void sumDouble() {
    MathOperation s = new SumEx();
    assertEquals(3.8,s.math(1.0,2.8));
  }
  @Test
  void sumInt() {
    MathOperation s = new SumEx();
    assertEquals(5,s.math(5,0));
  }
  @Test
  void sumDoubleO() {
    MathOperation s = new SumEx();
    Double d = new Double(1.0);
    Double d1 = new Double(2.8);
    assertEquals(3.8,s.math(d,d1));
  }
  @Test
  void sumIntO() {
    MathOperation s = new SumEx();
    Integer d = new Integer(7);
    Integer d1 = new Integer(3);
    assertEquals(10,s.math(d,d1));
  }
  @Test
  void sumIO() {
    MathOperation s = new SumEx();
    int d = 7;
    Integer d1 = new Integer(3);
    //при попыке вызвать метод с не определенным параметром компилятор ругаестся
    //assertEquals(10,s.math(d, d1));
  }



  @Test
  void multiDouble() {
    MathOperation s = new MultiEx();
    assertEquals(2.8,s.math(1.0,2.8));
  }
  @Test
  void testMultiInt() {
    MathOperation s = new MultiEx();
    assertEquals(0,s.math(5,0));
  }
  @Test
  void multiDoubleO() {
    MathOperation s = new MultiEx();
    Double d = new Double(1.0);
    Double d1 = new Double(2.8);
    assertEquals(2.8,s.math(d,d1));
  }
  @Test
  void multiIntO() {
    MathOperation s = new MultiEx();
    Integer d = new Integer(7);
    Integer d1 = new Integer(3);
    assertEquals(21,s.math(d,d1));
  }
  @Test
  void mumIO() {
    MathOperation s = new MultiEx();
    int d = 7;
    Integer d1 = new Integer(3);
    //при попыке вызвать метод с не определенным параметромкомпилятор ругаестся
    //assertEquals(30,s.math(d, d1));
  }
}
