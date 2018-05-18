import org.junit.Test;

import static org.junit.Assert.*;

public class CoinsTest {

  @Test
  public void test1() {
    long ways = Coins.getWays(10, new int[] { 2, 5, 3, 6 });

    assertEquals(5, ways);
  }

  @Test
  public void test2() {
    long ways = Coins.getWays(4, new int[] { 1, 2, 3 });

    assertEquals(4, ways);
  }
}