package module1.src.main.java.net.broscorp.boxing;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;




/*
* Написать тест, в котором сравнение двух оберточных типов с одинаковым значением через == даёт true.
  Написать тест, в котором сравнение двух оберточных типов с одинаковым значением через == даёт false.
  Написать тест в котором неявный анбоксинг вызывает исключение.
*
*
*
*
* */


public class FirstTest
{

  private net.broscorp.boxing.tests.MyGenetic<?> input;

  @BeforeEach
  public void setUp() throws Exception {
    // just an example, there can be any wrapper and any value
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
  public void testIsEqual()
  {

    try {
      assertTrue(input.isEqualTrue(new net.broscorp.boxing.tests.MyGenetic<Double>(2.0), new net.broscorp.boxing.tests.MyGenetic<Double>(2.0)));

    /*
      assertTrue(input.isEqualFalse(new MyGenetic<Double>(2.0), new MyGenetic<Double>(2.0)));
     // second method
    */

    } catch (Exception e) {
      e.printStackTrace();
    }

  }








}
