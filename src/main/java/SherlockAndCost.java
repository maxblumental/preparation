import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SherlockAndCost {

  static int cost(int[] B) {

    int high = 0;
    int low = 0;

    for (int i = 1; i < B.length; i++) {
      int highToLow = Math.abs(B[i - 1] - 1);
      int lowToHigh = Math.abs(B[i] - 1);
      int highToHigh = Math.abs(B[i] - B[i - 1]);

      high = Math.max(low + lowToHigh, high + highToHigh);
      low = Math.max(high + highToLow, low);
    }

    return Math.max(high, low);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    try (BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")))) {

      int t = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int tItr = 0; tItr < t; tItr++) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int BItr = 0; BItr < n; BItr++) {
          int BItem = Integer.parseInt(BItems[BItr]);
          B[BItr] = BItem;
        }

        int result = cost(B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      }

      bufferedWriter.close();
    }

    scanner.close();
  }
}
