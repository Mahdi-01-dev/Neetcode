import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> diffs = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (diffs.containsKey(num)) {
        return new int[] {i, diffs.get(num)};
      }
      diffs.put(target - num, i);
    }
    return new int[] {};
  }
}
