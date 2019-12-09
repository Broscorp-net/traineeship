import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BoxingTest {
  @Test
  public void boxTest(){
    Integer i1 = new Integer(10);
    Integer i2 = new Integer(10);
    //В оберточных типах == сравнивает ссылки на обьекты
    // но их можно сравнить при помощи equals(сравнивает значение)
    assert(i1 != i2 );
    assert(i1.equals(i2));
  }

  @Test
  public  void hardBoxing(){
    //"ручной" боксинг/анбоксинг
    int i = 10;
    Integer i1 = new Integer(i);
    int c = i1.intValue();
    assertEquals(c, i);
  }
}
