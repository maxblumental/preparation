package oil;

import org.junit.Test;

import static oil.ArrayLibrary.allButOne;
import static oil.ArrayLibrary.leftNeighbor;
import static oil.ArrayLibrary.makeLeftMerge;
import static oil.ArrayLibrary.makeRightMerge;
import static oil.ArrayLibrary.rightNeighbor;
import static org.junit.Assert.*;

public class ArrayLibraryTest {

  @Test
  public void leftNeighbor1() {
    assertEquals(3, leftNeighbor(0, new int[] { 1, 2, 3 }));
  }

  @Test
  public void leftNeighbor2() {
    assertEquals(1, leftNeighbor(1, new int[] { 1, 2, 3 }));
  }

  @Test
  public void leftNeighbor3() {
    assertEquals(2, leftNeighbor(2, new int[] { 1, 2, 3 }));
  }

  @Test
  public void rightNeighbor1() {
    assertEquals(2, rightNeighbor(0, new int[] { 1, 2, 3 }));
  }

  @Test
  public void rightNeighbor2() {
    assertEquals(3, rightNeighbor(1, new int[] { 1, 2, 3 }));
  }

  @Test
  public void rightNeighbor3() {
    assertEquals(1, rightNeighbor(2, new int[] { 1, 2, 3 }));
  }

  @Test
  public void allButOne1() {
    assertArrayEquals(new int[] { -1, 2, 3 }, allButOne(0, new int[] { 1, 2, 3 }));
  }

  @Test
  public void allButOne2() {
    assertArrayEquals(new int[] { 1, -1, 3 }, allButOne(1, new int[] { 1, 2, 3 }));
  }

  @Test
  public void allButOne3() {
    assertArrayEquals(new int[] { 1, 2, -1 }, allButOne(2, new int[] { 1, 2, 3 }));
  }

  @Test
  public void allButOne4() {
    assertArrayEquals(new int[] { -1, 2 }, allButOne(0, new int[] { 1, 2 }));
  }

  @Test
  public void allButOne5() {
    assertArrayEquals(new int[] { 1, -1 }, allButOne(1, new int[] { 1, 2 }));
  }

  @Test
  public void allButOne6() {
    assertArrayEquals(new int[] { -1, 2, 3, 4 }, allButOne(0, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void allButOne7() {
    assertArrayEquals(new int[] { 1, -1, 3, 4 }, allButOne(1, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void allButOne8() {
    assertArrayEquals(new int[] { 1, 2, -1, 4 }, allButOne(2, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void allButOne9() {
    assertArrayEquals(new int[] { 1, 2, 3, -1 }, allButOne(3, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeRightMerge1() {
    assertArrayEquals(new int[] { 3, 3 }, makeRightMerge(0, new int[] { 1, 2, 3 }));
  }

  @Test
  public void makeRightMerge2() {
    assertArrayEquals(new int[] { 1, 5 }, makeRightMerge(1, new int[] { 1, 2, 3 }));
  }

  @Test
  public void makeRightMerge3() {
    assertArrayEquals(new int[] { 4, 2 }, makeRightMerge(2, new int[] { 1, 2, 3 }));
  }

  @Test
  public void makeRightMerge4() {
    assertArrayEquals(new int[] { 3 }, makeRightMerge(0, new int[] { 1, 2 }));
  }

  @Test
  public void makeRightMerge5() {
    assertArrayEquals(new int[] { 3 }, makeRightMerge(1, new int[] { 1, 2 }));
  }

  @Test
  public void makeRightMerge6() {
    assertArrayEquals(new int[] { 3, 3, 4 }, makeRightMerge(0, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeRightMerge7() {
    assertArrayEquals(new int[] { 1, 5, 4 }, makeRightMerge(1, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeRightMerge8() {
    assertArrayEquals(new int[] { 1, 2, 7 }, makeRightMerge(2, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeRightMerge9() {
    assertArrayEquals(new int[] { 5, 2, 3 }, makeRightMerge(3, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeLeftMerge1() {
    assertArrayEquals(new int[] { 2, 4 }, makeLeftMerge(0, new int[] { 1, 2, 3 }));
  }

  @Test
  public void makeLeftMerge2() {
    assertArrayEquals(new int[] { 3, 3 }, makeLeftMerge(1, new int[] { 1, 2, 3 }));
  }

  @Test
  public void makeLeftMerge3() {
    assertArrayEquals(new int[] { 1, 5 }, makeLeftMerge(2, new int[] { 1, 2, 3 }));
  }

  @Test
  public void makeLeftMerge4() {
    assertArrayEquals(new int[] { 3 }, makeLeftMerge(0, new int[] { 1, 2 }));
  }

  @Test
  public void makeLeftMerge5() {
    assertArrayEquals(new int[] { 3 }, makeLeftMerge(1, new int[] { 1, 2 }));
  }

  @Test
  public void makeLeftMerge6() {
    assertArrayEquals(new int[] { 2, 3, 5 }, makeLeftMerge(0, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeLeftMerge7() {
    assertArrayEquals(new int[] { 3, 3, 4 }, makeLeftMerge(1, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeLeftMerge8() {
    assertArrayEquals(new int[] { 1, 5, 4 }, makeLeftMerge(2, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void makeLeftMerge9() {
    assertArrayEquals(new int[] { 1, 2, 7 }, makeLeftMerge(3, new int[] { 1, 2, 3, 4 }));
  }
}