package disjointset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  static int[] componentsInGraph(int[][] gb) {
    DisjointSet disjointSet = new DisjointSet(gb.length * 2);
    for (int[] edge : gb) {
      int i = edge[0];
      int j = edge[1];
      disjointSet.makeSet(i);
      disjointSet.makeSet(j);
      disjointSet.union(i, j);
    }
    return disjointSet.minMaxSize();
  }

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);

    try (BufferedWriter bufferedWriter =
             new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

      int n = scanner.nextInt();
      int[][] gb = new int[n][2];

      for (int i = 0; i < n; i++) {
        gb[i][0] = scanner.nextInt();
        gb[i][1] = scanner.nextInt();
      }

      int[] result = componentsInGraph(gb);

      for (int i = 0; i < result.length; i++) {
        bufferedWriter.write(String.valueOf(result[i]));
        if (i != result.length - 1) {
          bufferedWriter.write(" ");
        }
      }

      bufferedWriter.newLine();
    }
  }

  private static class DisjointSet {

    private int[] parent;
    private int[] rank;

    DisjointSet(int size) {
      parent = new int[size + 1];
      rank = new int[size + 1];
    }

    void makeSet(int i) {
      if (parent[i] != 0) {
        return;
      }
      parent[i] = i;
      rank[i] = 0;
    }

    private int find(int i) {
      if (parent[i] != i) {
        parent[i] = find(parent[i]);
      }
      return parent[i];
    }

    void union(int i, int j) {
      int pi = find(i);
      int pj = find(j);

      if (pi == pj) {
        return;
      }

      if (rank[pi] > rank[pj]) {
        parent[pj] = pi;
      } else {
        parent[pi] = pj;
        if (rank[pi] == rank[pj]) {
          rank[pj] += 1;
        }
      }
    }

    int[] minMaxSize() {
      int[] sizes = new int[parent.length];
      for (int i = 1; i < parent.length; i++) {
        int j = find(i);
        sizes[j] += 1;
      }
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i = 1; i < parent.length; i++) {
        if (sizes[i] > max) {
          max = sizes[i];
        }
        if (sizes[i] < min && sizes[i] != 0) {
          min = sizes[i];
        }
      }
      return new int[] { min, max };
    }
  }
}
