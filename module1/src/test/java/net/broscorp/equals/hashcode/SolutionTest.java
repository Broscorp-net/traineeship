package net.broscorp.equals.hashcode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  public void testHashcodeExcectedTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);

    Assertions.assertTrue(firstSol.hashCode() == secondSol.hashCode());

    secondSol.setFirstValue(10);
    secondSol.setSecondValue(20);

    Assertions.assertFalse(firstSol.hashCode() == secondSol.hashCode());
  }

  @Test
  public void testEqualsExcectedTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);

    Assertions.assertTrue(firstSol.equals(secondSol));

    secondSol.setFirstValue(10);
    secondSol.setSecondValue(20);

    Assertions.assertFalse(firstSol.equals(secondSol));
  }

  @Test
  public void testFindSolutionWithSameHashcodeButNotEqualsExcectedTrue() {
    List<Solution> solutions =
        Arrays.asList(new Solution(10, 20), new Solution(20, 10), new Solution(15, 15));

    System.out.println("вот список разных объектов:" + solutions + " мы видем что они разные"
        + " но их hashcode одинаковый " + solutions.get(0).hashCode() + " "
        + solutions.get(1).hashCode() + " " + solutions.get(2).hashCode());

    for (int i = 0; i < solutions.size() - 1; i++) {
      Solution firstSol = solutions.get(i);
      Solution secondSol = solutions.get(i + 1);

      Assertions.assertEquals(firstSol.hashCode(), secondSol.hashCode());
      Assertions.assertNotEquals(firstSol, secondSol);
    }
  }
  
  @Test
  public void testEqualsReflexivityExcectedIsTrue() {
    Solution sol = new Solution(1, 2);
    Assertions.assertTrue(sol.equals(sol));
  }
  
  @Test
  public void testEqualsWithNullExcectedIsFalse() {
    Solution sol = new Solution(1, 2);
    Assertions.assertFalse(sol.equals(null));
  }
  
  @Test
  public void testEqualsSymmetryExcectedIsTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);

    Assertions.assertTrue(firstSol.equals(secondSol));
    Assertions.assertTrue(secondSol.equals(firstSol));
  }
  
  @Test
  public void testEqualsTransitivityExcectedIsTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);
    Solution thirdSol = new Solution(1, 2);

    Assertions.assertTrue(firstSol.equals(secondSol));
    Assertions.assertTrue(secondSol.equals(thirdSol));
    Assertions.assertTrue(firstSol.equals(thirdSol));
  }
  
  @Test
  public void testEqualsConsistencyTrue() {
    Solution firstSol = new Solution(1, 2);
    Solution secondSol = new Solution(1, 2);
    
    for (int i = 0; i < 10; i++) {
      Assertions.assertTrue(firstSol.equals(secondSol));
    }
    
    secondSol.setFirstValue(10);
    secondSol.setSecondValue(20);

    Assertions.assertFalse(firstSol.equals(secondSol));
  }
}
