package valueref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {
  Foo foo = new Foo();

  @Test
  public void passParametersByValueThatIsTheReasonTheyDoNotChangeAfterTheActionDoingOnIt() {
    int i = 0;
    List<String> s = new ArrayList<>();

    Assertions.assertEquals(0,i);

    foo.foo(i,s);

    Assertions.assertEquals(0,i);
    Assertions.assertNotEquals(15,i);
  }

  @Test
  public void passParametersByReferenceThatIsTheReasonTheyChangeAfterTheActionDoingOnThem() {
    int i = 0;
    List<String> s = new ArrayList<>();

    Assertions.assertEquals("[]",Arrays.toString(s.toArray()));

    foo.foo(i,s);

    Assertions.assertEquals("[d]",Arrays.toString(s.toArray()));
    Assertions.assertNotEquals("[]",Arrays.toString(s.toArray()));
  }

}
