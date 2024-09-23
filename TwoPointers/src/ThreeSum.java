import java.util.*;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int prev = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
      int num = nums[i];
      if (num == prev) {
        continue;
      }
      int l = i + 1;
      int r = nums.length - 1;
      int target = -num;
      int sum = nums[l] + nums[r];
      while (l < r) {
        if (sum < target) {
          l++;
        } else if (sum > target) {
          r--;
        } else {
          result.add(List.of(nums[i], nums[l], nums[r]));
          int lPrev = nums[l];
          int rPrev = nums[r];
          while (l < r && nums[l] == lPrev) {
            l++;
          }
          while (l < r && nums[r] == rPrev) {
            r--;
          }
        }
        sum = nums[l] + nums[r];
      }
      prev = num;
    }
    return result;
  }

  public List<List<Integer>> solution(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) break; //More efficient as we don't have to go through the entire array
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int l = i + 1;
      int r = nums.length - 1;
      int target = -nums[i];

      while (l < r) {
        int sum = nums[l] + nums[r];
        System.out.println("["+nums[i]+","+nums[l]+","+nums[r]+"]");
        if (sum < target) {
          l++;
        } else if (sum > target) {
          r--;
        } else {
          result.add(List.of(nums[i], nums[l], nums[r]));
          l++;
          r--;
          while (l < r && nums[l] == nums[l - 1]) l++;
          while (l < r && nums[r] ==  nums[r + 1]) r--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-1,0,1,2,-1,-4};
    ThreeSum threeSum = new ThreeSum();
    threeSum.solution(nums);
  }
}
