import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void byteOverflow() {
    //Не сморя на то что мы увеличиваем значение: оно санет меньше нуля
    byte b = 0;
    b += Byte.MAX_VALUE + 1;
    assert (b < 0);
  }

  @Test
  public void shortOverflow() {
    //Не сморя на то что мы увеличиваем значение: оно санет меньше нуля
    short s = 0;
    s += Short.MAX_VALUE + 1;
    assert (s < 0);
  }

  @Test
  public void intOverflow() {
    //Не сморя на то что мы увеличиваем значение: оно санет меньше нуля
    int i = 0;
    i += Integer.MAX_VALUE + 1;
    assert (i < 0);
  }


  @Test
  public void longConvert() {
    long l = Integer.MAX_VALUE + 1L;
    //при конвертации long в int может произойти переполнение
    int i = (int) l;
    assert (i <= -1);
  }

  @Test
  public void floatConvertInfinity() {
    double d = Double.MAX_VALUE;
    //при конвертации double в float, float может превратится в бесконечность
    float f = (float) (d);
    assert (Float.toString(f).equals("Infinity"));
  }

  @Test
  public void floatDeviation() {
    double d = 99999999.33333333;
    //при конвертации double в float, могут происходить погрешности
    float f = (float) (d);

    System.out.println("After covert");
    System.out.println(String.format("Float: %.10f\t", f));
    System.out.println(String.format("Double: %.10f\t", d));
    assert ((double) f != d);
  }

}

