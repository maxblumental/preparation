package oil;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OilDistributionTest {

  private OilDistribution solution;

  @Before
  public void setUp() {
    solution = new OilDistribution();
  }

  @Test
  public void test1() {
    assertEquals(5, solution.smallestDifference(2, new int[] { 6, 13, 10, 2 }));
  }

  @Test
  public void test2() {
    assertEquals(1, solution.smallestDifference(2, new int[] { 6, 13, 2, 10 }));
  }

  @Test
  public void test3() {
    assertEquals(11, solution.smallestDifference(3, new int[] { 6, 13, 2 }));
  }

  @Test
  public void test4() {
    assertEquals(11, solution.smallestDifference(4, new int[] { 6, 13, 2, 5 }));
  }

  @Test
  public void test5() {
    assertEquals(7, solution.smallestDifference(4, new int[] { 6, 13, 2, 5, 7 }));
  }

  @Test
  public void testN() {
    assertEquals(29,
        solution.smallestDifference(4, new int[] { 100, 92, 133, 201, 34, 34, 34, 94, 108 }));
  }

  @Test
  public void testTime() {
    int N = 8;
    int M = 20;
    int[] areas = new int[M];
    Random random = new Random();
    for (int i = 0; i < M; i++) {
      areas[i] = 1 + random.nextInt(100000);
    }

    long t1 = System.currentTimeMillis();
    solution.smallestDifference(N, areas);
    long t2 = System.currentTimeMillis();

    System.out.printf("Time: %d\n", t2 - t1);
    System.out.printf("Cache rate 1: %f\n", solution.cacheRate1());
    System.out.printf("Cache rate 2: %f\n", solution.cacheRate2());
  }
}