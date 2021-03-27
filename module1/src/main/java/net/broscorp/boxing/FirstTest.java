package module1.src.main.java.net.broscorp.boxing;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest {

  private net.broscorp.boxing.tests.MyGenetic<?> input;

  @BeforeEach
  public void setUp() throws Exception {
    input = new net.broscorp.boxing.tests.MyGenetic<Double>(2.0);
  }

  public net.broscorp.boxing.tests.MyGenetic<?> getInput() {
    return input;
  }

  public void setInput(net.broscorp.boxing.tests.MyGenetic<?> input) {
    this.input = input;
  }

  @Test
  @DisplayName("Simple code should work")
  public void testIsEqual() {

    try {
      assertTrue(input.isEqualTrue(new net.broscorp.boxing.tests.MyGenetic<Double>(2.0),
          new net.broscorp.boxing.tests.MyGenetic<Double>(2.0)));

      assertTrue(input.isEqualFalse(new net.broscorp.boxing.tests.MyGenetic<Double>(2.0),
          new net.broscorp.boxing.tests.MyGenetic<Double>(2.0)));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
