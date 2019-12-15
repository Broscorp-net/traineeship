import static org.junit.jupiter.api.Assertions.*;

import net.broscorp.h_generics.MyCoolList;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  @Test
  void getAdd() {
    MyCoolList<Integer> mcl = new MyCoolList();
    mcl.add(15);
    assertEquals(15, mcl.get(0));
  }

  @Test
  void removeAdd() {
    MyCoolList<Integer> mcl = new MyCoolList();
    mcl.add(15);
    mcl.add(10);
    mcl.remove(0);
    assertEquals(10, mcl.get(0));
  }

  @Test
  void map() {
    MyCoolList<Integer> mcl = new MyCoolList();
    mcl.add(15);
    mcl.add(10);
    MyCoolList<Integer> mcl1 = mcl.map(x -> (Integer) x * 2);
    assertEquals(30, mcl1.get(0));
    assertEquals(20, mcl1.get(1));
  }

  @Test
  void size() {
    MyCoolList<Integer> mcl = new MyCoolList();
    mcl.add(15);
    mcl.add(10);
    mcl.add(10);
    assertEquals(3, mcl.size());
  }
}