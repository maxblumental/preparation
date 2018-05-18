package sda;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static sda.Solution.fastPower;

public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test public void test() {
    assertEquals(32, fastPower(2, 5, 107));
  }

  @Test public void test1() {
    assertEquals(61, fastPower(2, 10, 107));
  }

  @Test public void test3() {
    List<Integer> list = Arrays.asList(0, 3, 0, 1, 2, 1, 3, 1, 0);

    solution.estimatePowers(list);

    assertEquals(48303, solution.function(list));
  }

  @Test public void test4() {
    List<Integer> list = Arrays.asList(0, 0, 0, 0);

    solution.estimatePowers(list);

    assertEquals(7, solution.function(list));
  }

  @Test public void test5() {
    List<Integer> list = Arrays.asList(0, 1, 0);

    solution.estimatePowers(list);

    assertEquals(8, solution.function(list));
  }

  @Test public void test8() {
    List<Integer> list = Arrays.asList(0, 1, 0, 0);

    solution.estimatePowers(list);

    System.out.println(solution.function(list));
  }

  @Test public void test6() {
    List<Integer> list = Arrays.asList(0, 100, 0);

    solution.estimatePowers(list);

    assertEquals(905485119, solution.function(list));
  }
}