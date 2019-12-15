import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.broscorp.i_equals_hashcode.Worker;
import org.junit.jupiter.api.Test;


class WorkerTest {

  @Test
  public void eqHash1() {
    //обьект равен самому себе
    Worker w1 = new Worker(1, "Bob", 25);
    assert (w1.equals(w1));
  }

  @Test
  public void eqHash2() {
    //одинаковые обьекты равы
    Worker w1 = new Worker(1, "Bob", 25);
    Worker w2 = new Worker(1, "Bob", 25);
    assert (w1.equals(w2));
    assert (w2.equals(w1));
  }

  @Test
  public void eqHash3() {
    //одинаковые обьекы всегда равны
    Worker w1 = new Worker(1, "Bob", 25);
    Worker w2 = new Worker(1, "Bob", 25);
    for (int i = 0; i < 100; i++) {
      assert (w1.equals(w2));
    }
  }

  @Test
  public void eqHash4() {
    //Инициализированый обьект не равен NULL
    Worker w1 = new Worker(1, "Bob", 25);
    assert (!w1.equals(null));
  }

  @Test
  public void eqHash5() {
    //У одинаковых обьектов хеш коды равны
    Worker w1 = new Worker(1, "Bob", 25);
    Worker w2 = new Worker(1, "Bob", 25);
    assert (w1.hashCode() == w2.hashCode());
  }

  @Test
  public void eqHash6() {
    //Обьекы с разными хеш кодами не могу быть равны
    Worker w1 = new Worker(2, "Sam", 30);
    Worker w2 = new Worker(1, "Bob", 25);
    assert (w1.hashCode() != w2.hashCode());
    assert (!w1.equals(w2));
  }

  @Test
  public void eqHash7() {
    //обьекты с одинаковыми хеш кодами не обязаельно равны
    boolean b = false;
    Map<Integer, Worker> map = new HashMap<>();
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      Worker w = new Worker(i, "Sam", 25);

      if (!map.containsKey(w.hashCode())) {
        map.put(w.hashCode(), w);
      } else {
        System.out.println(w);
        System.out.println(map.get(w.hashCode()));
        System.out.println("Hash code: " + w.hashCode());
        b = true;
        break;
      }
    }
    assert (b);
  }
}