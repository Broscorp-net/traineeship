package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class GarbageCollectionTest {

  public List<ThirdClass> list = new ArrayList<>();

  @Test
  public void gcFirstTest() {
    for (int i = 0; i < 10_000; i++) {
      FirstClass first = new FirstClass(i,"first",i);
      first.counterText();
      SecondClass second = new SecondClass(i,"second",i);
      second.counterText();
      System.gc();
    }
  }

  @Test
  public void gcSecondTest() {
    for (int i = 0; i < 10_000; i++) {
      FirstClass first = new FirstClass(i,"first",i);
      SecondClass second = new SecondClass(i,"second",i);
      first.setEntity(second);
      second.setEntity(first);
      System.gc();
    }
  }

  @Test
  public void gcThirdTest() {
    for (int i = 0; i < 10_000; i++) {
      ThirdClass third = new ThirdClass(i, this);
      //list.add(third);
      System.gc();
    }
    System.out.println(list.size());
    //assertEquals(9999,list.size());
  }
}
