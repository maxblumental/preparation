package disjointset;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void test1() {
    int[][] gb = {
        { 1, 6 },
        { 2, 7 },
        { 3, 8 },
        { 4, 9 },
        { 2, 6 }
    };

    assertArrayEquals(new int[] { 2, 4 }, Solution.componentsInGraph(gb));
  }
}