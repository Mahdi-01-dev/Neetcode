public class TwoSumII {
  public int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int r = numbers.length - 1;
    int sum = numbers[l] + numbers[r];
    while (sum != target) {
      if (sum < target) {
        sum = numbers[++l] + numbers[r];
      } else {
        sum = numbers[l] + numbers[--r];
      }
    }
    return new int[]{++l, ++r};
  }
}
