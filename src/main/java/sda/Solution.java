package sda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  private static final int P = 1_000_000_007;

  private List<Integer> powers;

  void estimatePowers(List<Integer> list) {
    List<Integer> powers = new ArrayList<>();
    for (Integer d : list) {
      powers.add((int) fastPower(2, d, P));
    }
    this.powers = powers;
  }

  long function(List<Integer> list) {
    int size = list.size();

    int i = powers.size() - size;

    if (size == 0) {
      return 0;
    } else if (size == 1) {
      return powers.get(i);
    } else if (size == 2) {
      long p1 = powers.get(i);
      long p2 = powers.get(i + 1);
      long mul = p1 * p2 % P;
      long sum = p1 + p2 % P;
      return (sum + mul - 1) % P;
    }

    long first = powers.get(i) * function(list.subList(1, size)) % P;
    long second = powers.get(i + 1) * function(list.subList(2, size)) % P;
    long third = powers.get(i + 1);

    return (first + second + third) % P;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(scanner.nextInt());
    }
    Solution solution = new Solution();
    solution.estimatePowers(list);
    System.out.println(solution.function(list));
  }

  static long fastPower(long x, long d, long p) {
    if (d == 0) {
      return 1;
    }
    if (d == 1) {
      return x % p;
    }
    long square = x * x % p;
    if (d % 2 == 1) {
      return x * fastPower(square, (d - 1) / 2, p) % p;
    }
    return fastPower(square, d / 2, p) % p;
  }
}
