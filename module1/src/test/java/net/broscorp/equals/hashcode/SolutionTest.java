package net.broscorp.equals.hashcode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  public void testHashcodeExcetedTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);

    Assertions.assertTrue(firstSol.hashCode() == secondSol.hashCode());

    secondSol.setFirstValue(10);
    secondSol.setSecondValue(20);

    Assertions.assertFalse(firstSol.hashCode() == secondSol.hashCode());
  }

  @Test
  public void testEqualsExcetedTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);

    Assertions.assertTrue(firstSol.equals(secondSol));

    secondSol.setFirstValue(10);
    secondSol.setSecondValue(20);

    Assertions.assertFalse(firstSol.equals(secondSol));
  }

  @Test
  public void testFindSolutionWithSameHashcodeButNotEqualsExceptedTrue() {
    List<Solution> solutions =
        Arrays.asList(new Solution(10, 20), new Solution(20, 10), new Solution(15, 15));

    for (int i = 0; i < solutions.size() - 1; i++) {
      Solution firstSol = solutions.get(i);
      Solution secondSol = solutions.get(i + 1);

      Assertions.assertEquals(firstSol.hashCode(), secondSol.hashCode());
      Assertions.assertNotEquals(firstSol, secondSol);
    }
  }
}
