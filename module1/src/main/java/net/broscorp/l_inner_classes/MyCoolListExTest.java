package net.broscorp.l_inner_classes;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class MyCoolListExTest {

  @Test
  void getAdd() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    assert (15 == mcl.get(0));
  }

  @Test
  void removeAdd() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    mcl.remove(0);
   assert (10 == mcl.get(0));
  }

  @Test
  void map() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    MyCoolListEx<Integer> mcl1 = mcl.map(x -> (Integer) x * 2);
    assert (30 == mcl1.get(0));
    assert (20 == mcl1.get(1));
  }

  @Test
  void hasNext(){
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    mcl.next();
    mcl.next();
    assert (!mcl.hasNext());
  }
  @Test
  void hasNextNo(){
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    assert (mcl.hasNext());
  }

  @Test
  void next(){
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    assert (15 == mcl.next());
  }

  @Test
  void nextNo(){
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    mcl.next();
    mcl.next();
    try {
      mcl.next();
      assert (false);
    }catch (NoSuchElementException e){
      assert (true);
    }
  }
}