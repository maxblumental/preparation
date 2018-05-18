package disjointset;

public class DisjointSet {

  private int[] parent;
  private int[] rank;

  DisjointSet(int size) {
    parent = new int[size + 1];
    rank = new int[size + 1];
  }

  public void makeSet(int i) {
    parent[i] = i;
    rank[i] = 0;
  }

  private int find(int i) {
    if (parent[i] != i) {
      parent[i] = find(parent[i]);
    }
    return parent[i];
  }

  public boolean contains(int i) {
    return parent[i] != 0;
  }

  public void union(int i, int j) {
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

  public int[] minMaxSize() {
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
