public class Triangle {

  static int triangle(int a, int b, int c) {
    if (a + b > c && a + c > b && b + c > a) {
      if (a == b && b == c) {
        return 1;
      }
      return 2;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(triangle(3, 4, 5));
    System.out.println(triangle(3, 3, 3));
  }
}
