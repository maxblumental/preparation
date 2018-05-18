import java.util.Arrays;
import java.util.Scanner;

public class Coins {

  static long getWays(int n, int[] c) {
    long[] ways = new long[n + 1];
    Arrays.sort(c);

    for (int denomination : c) {
      for (int i = 0; i < n + 1; i++) {
        if (denomination > i) {
          continue;
        }

        if (denomination == i) {
          ways[i] += 1;
        } else {
          ways[i] += ways[i - denomination];
        }
      }
    }

    return ways[n];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] c = new int[m];
    for (int c_i = 0; c_i < m; c_i++) {
      c[c_i] = in.nextInt();
    }
    long ways = getWays(n, c);
    System.out.println(ways);
  }
}
