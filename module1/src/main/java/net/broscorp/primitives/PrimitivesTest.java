public class PrimitivesTest {
  @Test
  public void plusIntOverflowTest() {
    int result = Integer.MIN_VALUE;
    Assert.assertEquals("Compare", result, Primitives.plusIntOverflow())
  }
}