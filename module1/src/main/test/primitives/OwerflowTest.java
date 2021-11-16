package primitives;


import static org.junit.jupiter.api.Assertions.assertEquals;

import net.broscorp.primitives.owerflow.Owerflow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwerflowTest {

  private Owerflow owerflow;

  @BeforeEach
  public void initOwerflow() {
    owerflow = new Owerflow();
  }

  @Test
  public void maxIntegerOwerflowTest() {
    assertEquals(-2147483648, owerflow.maxIntOwerflow(1));
  }

  @Test
  public void maxLongOwerflowTest() {
    assertEquals(-9223372036854775808L, owerflow.maxLongOwerflow(1));
  }

  @Test
  public void maxByteOwerflowTest() {
    assertEquals(-128, owerflow.maxByteOwerflow(1));
  }

  @Test
  public void maxShortOwerflowTest() {
    assertEquals(-32768, owerflow.maxShortOwerflow(1));
  }
}
