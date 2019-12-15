import net.broscorp.l_inner_classes.MyCoolListEx;

import static org.junit.jupiter.api.Assertions.*;

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
  void hasNext() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    mcl.iterator().next();
    mcl.iterator().next();
    assert (!mcl.iterator().hasNext());
  }

  @Test
  void hasNextNo() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    assert (mcl.iterator().hasNext());
  }

  @Test
  void next() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    assert (15 == mcl.iterator().next());
  }

  @Test
  void nextNo() {
    MyCoolListEx<Integer> mcl = new MyCoolListEx();
    mcl.add(15);
    mcl.add(10);
    mcl.iterator().next();
    mcl.iterator().next();
    assertThrows(NoSuchElementException.class, () -> {
      mcl.iterator().next();
    });
  }
}