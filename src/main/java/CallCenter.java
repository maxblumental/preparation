import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CallCenter {

  static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
    Set<Integer> set = new HashSet<>();
    for (int[] callsTime : callsTimes) {
      set.add(callsTime[0]);
      set.add(callsTime[1]);
    }
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);

    int maxOverlap = 0;
    for (int i = 0; i < set.size() - 1; i++) {
      int start = list.get(i);
      int end = list.get(i + 1);

      int[] segment = { start, end };
      int startSearch = Arrays.binarySearch(callsTimes, segment,
          Comparator.comparingInt(value -> value[0]));
      int startIndex = startSearch > 0 ? startSearch : -startSearch - 1;

      int overlap = 0;
      for (int j = 0; j < startIndex + 1; j++) {
        if (j < callsTimes.length && callsTimes[j][1] >= end) {
          overlap++;
        }
      }

      if (overlap > maxOverlap) {
        maxOverlap = overlap;
      }
    }

    return maxOverlap - noOfCurrentAgents;
  }

  public static void main(String[] args) {
    int number = howManyAgentsToAdd(1, new int[][] {
        { 0, 20 },
        { 0, 40 },
        { 30, 35 }
    });
    System.out.println(number);
  }
}
