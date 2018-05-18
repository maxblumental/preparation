package oil;

class ArrayLibrary {

  static final int NO_VALUE = 1;

  static int rightNeighbor(int i, int[] areas) {
    return i == areas.length - 1 ? areas[0] : areas[i + 1];
  }

  static int leftNeighbor(int i, int[] areas) {
    return i == 0 ? areas[areas.length - 1] : areas[i - 1];
  }

  static int countValues(int[] numbers) {
    int counter = 0;
    for (int number : numbers) {
      if (number == NO_VALUE) {
        continue;
      }
      counter++;
    }
    return counter;
  }

  static int[] allButOne(int i, int[] areas) {
    int n = areas.length;
    int[] result = new int[n];
    System.arraycopy(areas, 0, result, 0, n);
    result[i] = NO_VALUE;
    return result;
  }

  static int[] makeRightMerge(int i, int[] areas) {
    int n = areas.length;
    int[] result = new int[n - 1];
    if (i == n - 1) {
      result[0] = areas[0] + areas[n - 1];
      System.arraycopy(areas, 1, result, 1, n - 2);
      return result;
    }
    result[i] = areas[i] + areas[i + 1];
    System.arraycopy(areas, 0, result, 0, i);
    if (i < n - 2) {
      System.arraycopy(areas, i + 2, result, i + 1, n - i - 2);
    }
    return result;
  }

  static int[] makeLeftMerge(int i, int[] areas) {
    int n = areas.length;
    int[] result = new int[n - 1];
    if (i == 0) {
      result[n - 2] = areas[0] + areas[n - 1];
      System.arraycopy(areas, 1, result, 0, n - 2);
      return result;
    }
    result[i - 1] = areas[i] + areas[i - 1];
    if (i > 1) {
      System.arraycopy(areas, 0, result, 0, i - 1);
    }
    if (n > i + 1) {
      System.arraycopy(areas, i + 1, result, i, n - i - 1);
    }
    return result;
  }

  static int sum(int[] numbers) {
    int counter = 0;
    for (int number : numbers) {
      if (number == NO_VALUE) {
        continue;
      }
      counter += number;
    }
    return counter;
  }

  static int getAmplitude(int[] numbers) {
    if (numbers.length < 2) {
      return 0;
    }
    int min = numbers[0];
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (min > numbers[i]) {
        min = numbers[i];
      }
      if (max < numbers[i]) {
        max = numbers[i];
      }
    }
    return max - min;
  }

  static int getAmplitude(int[] numbers, int givenMin, int givenMax) {
    if (numbers.length < 2) {
      return 0;
    }
    int min = givenMin;
    int max = givenMax;
    for (int number : numbers) {
      if (number == NO_VALUE) {
        continue;
      }
      if (min > number) {
        min = number;
      }
      if (max < number) {
        max = number;
      }
    }
    return max - min;
  }
}
