import java.util.Scanner;

public class ConstructTheArray {

  static long countArray(int n, int k, int x) {
    long mod = 1000000007;
    long counter1 = 1;
    long counter2 = 0;
    long prev1 = 1;
    long prev2 = 0;
    for (int i = 1; i < n; i++) {
      counter1 = prev2 * (k - 1) % mod;
      counter2 = (prev1 + (prev2 * (k - 2))) % mod;
      prev1 = counter1;
      prev2 = counter2;
    }
    if (x == 1) {
      return counter1;
    }
    return counter2;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int x = in.nextInt();
    long answer = countArray(n, k, x);
    System.out.println(answer);
    in.close();
  }
}
