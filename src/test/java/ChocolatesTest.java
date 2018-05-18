import org.junit.Test;

import static org.junit.Assert.*;

public class ChocolatesTest {

  @Test
  public void test1() {
    int equal = Chocolates.equal(new int[] { 1, 1, 5 });

    assertEquals(2, equal);
  }

  @Test
  public void test2() {
    int equal = Chocolates.equal(new int[] { 2, 2, 3, 7 });

    assertEquals(2, equal);
  }

  @Test
  public void test3() {
    assertEquals(0, Chocolates.getOpsNum(0));
  }

  @Test
  public void test4() {
    assertEquals(1, Chocolates.getOpsNum(1));
  }

  @Test
  public void test5() {
    assertEquals(2, Chocolates.getOpsNum(2));
  }

  @Test
  public void test6() {
    assertEquals(1, Chocolates.getOpsNum(3));
  }

  @Test
  public void test7() {
    assertEquals(2, Chocolates.getOpsNum(4));
  }

  @Test
  public void test8() {
    assertEquals(1, Chocolates.getOpsNum(5));
  }

  @Test
  public void test9() {
    assertEquals(3, Chocolates.getOpsNum(11));
  }

  @Test
  public void test10() {
    assertEquals(22, Chocolates.getOpsNum(104));
  }
}