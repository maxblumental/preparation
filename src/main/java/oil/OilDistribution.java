package oil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static oil.ArrayLibrary.NO_VALUE;
import static oil.ArrayLibrary.allButOne;
import static oil.ArrayLibrary.countValues;
import static oil.ArrayLibrary.getAmplitude;
import static oil.ArrayLibrary.leftNeighbor;
import static oil.ArrayLibrary.makeLeftMerge;
import static oil.ArrayLibrary.makeRightMerge;
import static oil.ArrayLibrary.rightNeighbor;
import static oil.ArrayLibrary.sum;

public class OilDistribution {

  private Map<Integer, Integer> memoization = new HashMap<>();
  private int cacheHits1 = 0;
  private int cacheHits2 = 0;
  private int cacheMisses1 = 0;
  private int cacheMisses2 = 0;

  int smallestDifference(int n, int[] areas) {
    int hash = Objects.hash(n, Arrays.hashCode(areas));

    if (memoization.containsKey(hash)) {
      cacheHits1++;
      return memoization.get(hash);
    }
    cacheMisses1++;

    if (n == areas.length) {
      int result = getAmplitude(areas);
      memoization.put(hash, result);
      return result;
    }

    if (n > areas.length) {
      throw new IllegalStateException("Got less areas than companies!");
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int current = areas[i];

      int min1 = smallestDifference(n, makeLeftMerge(i, areas));
      int min2 = smallestDifference(n, makeRightMerge(i, areas));
      int min3 = smallestDifference(n - 1, allButOne(i, areas), current, current);

      int min = min(min(min1, min2), min3);

      if (min < result) {
        result = min;
      }
    }

    memoization.put(hash, result);
    return result;
  }

  private int smallestDifference(int n, int[] areas, int givenMin, int givenMax) {
    int hash = Objects.hash(n, Arrays.hashCode(areas), givenMin, givenMax);

    if (memoization.containsKey(hash)) {
      cacheHits2++;
      return memoization.get(hash);
    }
    cacheMisses2++;

    if (n == 1) {
      int sum = sum(areas);
      int result = max(givenMax, sum) - min(givenMin, sum);
      memoization.put(hash, result);
      return result;
    }

    int length = countValues(areas);
    if (n == length) {
      int result = getAmplitude(areas, givenMin, givenMax);
      memoization.put(hash, result);
      return result;
    }

    if (n > length) {
      throw new IllegalStateException("Got less areas than companies!");
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int current = areas[i];

      if (current == NO_VALUE) {
        continue;
      }

      int min1 = leftNeighbor(i, areas) != NO_VALUE
          ? smallestDifference(n, makeLeftMerge(i, areas), givenMin, givenMax)
          : Integer.MAX_VALUE;
      int min2 = rightNeighbor(i, areas) != NO_VALUE
          ? smallestDifference(n, makeRightMerge(i, areas), givenMin, givenMax)
          : Integer.MAX_VALUE;
      int min3 = smallestDifference(n, allButOne(i, areas),
          min(givenMin, current), max(givenMax, current));

      int min = min(min(min1, min2), min3);

      if (min < result) {
        result = min;
      }
    }

    memoization.put(hash, result);
    return result;
  }

  double cacheRate1() {
    return cacheHits1 * 1. / (cacheHits1 + cacheMisses1);
  }

  double cacheRate2() {
    return cacheHits2 * 1. / (cacheHits2 + cacheMisses2);
  }

  public static void main(String[] args) {
    OilDistribution solution = new OilDistribution();
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int[] companies = new int[T];
    int[][] areas = new int[T][];
    for (int i = 0; i < T; i++) {
      int n = scanner.nextInt();
      companies[i] = n;
      areas[i] = new int[n];
      for (int j = 0; j < n; j++) {
        areas[i][j] = scanner.nextInt();
      }
    }
    for (int i = 0; i < T; i++) {
      System.out.printf("#%d %d", i + 1, solution.smallestDifference(companies[i], areas[i]));
    }
  }
}
