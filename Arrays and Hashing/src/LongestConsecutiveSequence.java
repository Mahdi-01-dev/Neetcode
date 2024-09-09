import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    Set<Integer> numbers = new HashSet<>();
    Set<Integer> starts = new HashSet<>();
    for (int num : nums) {
      numbers.add(num);
    }
    for (int num : nums) {
      if (!numbers.contains(num - 1)) {
        starts.add(num);
      }
    }

    int maxLength = 1;
    for (int start : starts) {
      int length = 1;
      while (numbers.contains(++start)) {
        length++;
      }
      if (length > maxLength) {
        maxLength = length;
      }
    }
    return maxLength;
  }

  public int solution(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int longest = 0;

    for (int n : numSet) {
      if (!numSet.contains(n - 1)) {
        int length = 1;
        while (numSet.contains(n + length)) {
          length++;
        }
        longest = Math.max(length, longest);
      }
    }
    return longest;
  }
}
