import java.util.ArrayList;
import java.util.List;

public class DeltaEncoding {

  static int[] delta_encode(int[] array) {
    List<Integer> list = new ArrayList<>();
    for (int i = array.length - 1; i > 0; i--) {
      int delta = array[i] - array[i - 1];
      list.add(delta);
      if (delta > 127 || delta < -127) {
        list.add(-128);
      }
    }
    list.add(array[0]);
    int[] answer = new int[list.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(answer.length - i - 1);
    }
    return answer;
  }
}
