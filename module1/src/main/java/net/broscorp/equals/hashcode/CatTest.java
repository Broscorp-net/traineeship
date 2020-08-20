package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CatTest {
  
  @Test
  public void identicalCodesIdenticaltValues() {
    Cat first = new Cat(1,"Vasya",3);
    Cat second = new Cat(1,"Vasya",3);
    assertEquals(first,second);
    assertEquals(first.hashCode(),second.hashCode());
  }
  
  @Test
  public void identicalCodesDifferentValues() {
    Cat first = new Cat(4,"Vasya",3);
    Cat second = new Cat(4,"Luisa", 4);
    assertNotEquals(first,second);
    assertEquals(first.hashCode(),second.hashCode());
  }
  
  @Test
  public void findIdenticalCodes() {
    List<Cat> cats = new ArrayList<Cat>();
    cats.add(new Cat(4,"Vasya",3));
    cats.add(new Cat(2,"Moska",1));
    cats.add(new Cat(1,"Leon",2));
    cats.add(new Cat(4,"Kravec",2));
    cats.add(new Cat(2,"Vasya",3));
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < cats.size() - 1; i++) {
      for (int j = i; j < cats.size(); j++) {
        if (i != j) {
          if (!cats.get(i).equals(cats.get(j))) {
            if (cats.get(i).hashCode() == cats.get(j).hashCode()) {
              map.put(i, j);
            }
          }
        }
      }
    }
    map.forEach(
        (k,v) -> {
          System.out.println(cats.get(k).toString() + " and " + cats.get(v).toString()
                + " have similar hashCode, but differente values");
          assertNotEquals(cats.get(k),cats.get(v));
          assertEquals(cats.get(k).hashCode(),cats.get(v).hashCode());
        });
  }
  
  
}
