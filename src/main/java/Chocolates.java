import java.util.Scanner;

public class Chocolates {

  static int getOpsNum(int n) {
    int result = 0;
    result += n / 5;
    n = n % 5;
    result += n / 3;
    n = n % 3;
    return result + n;
  }

  static int equal(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int n : arr) {
      if (n < min) {
        min = n;
      }
    }

    int minSteps = Integer.MAX_VALUE;
    int[] mins = new int[] { min, min - 1 };
    for (int m : mins) {
      int steps = 0;
      for (int n : arr) {
        steps += getOpsNum(n - m);
      }
      if (minSteps > steps) {
        minSteps = steps;
      }
    }

    return minSteps;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int arr_i = 0; arr_i < n; arr_i++) {
        arr[arr_i] = in.nextInt();
      }
      int result = equal(arr);
      System.out.println(result);
    }
    in.close();
  }
}
