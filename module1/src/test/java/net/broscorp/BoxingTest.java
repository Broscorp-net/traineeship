package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Junit5 boxing")
public class BoxingTest {

  private Integer firstCacheInteger;
  private Integer secondCacheInteger;
  private Integer newObjectInteger;
  private Integer firstNoCacheInteger;
  private Integer secondNoCacheInteger;
  private Integer nullInteger;


  @BeforeAll
    void setUp() {
    firstCacheInteger = 1;
    secondCacheInteger = 1;
    newObjectInteger = new Integer(1);
    firstNoCacheInteger = 128;
    secondNoCacheInteger = 128;
    nullInteger = null;
  }

  @Test
    void whenIntegerIsInARangeOfByteValues() {
    Assertions.assertSame(firstCacheInteger, secondCacheInteger);
  }

  @Test
    void whenIntegerIsCreatedViaNew() {
    Assertions.assertNotSame(firstCacheInteger, newObjectInteger);
  }

  @Test
    void whenIntegerIsOutOfRangeByteValues() {
    Assertions.assertNotSame(firstNoCacheInteger, secondNoCacheInteger);
  }

  void nullIntegerCastToInt() {
    int number = nullInteger;
  }

  @Test
    void thisMethodShouldThrowNullPointerExceptionForNullIntegerCastToInt() {
    Assertions.assertThrows(NullPointerException.class, this::nullIntegerCastToInt);
  }
}
