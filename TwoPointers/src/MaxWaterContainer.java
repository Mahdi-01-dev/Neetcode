public class MaxWaterContainer {
  public int maxArea(int[] heights) {
    int maxArea = 0;
    int l = 0;
    int r = heights.length - 1;
    while (l < r) {
      int minHeight = Integer.min(heights[l], heights[r]);
      int area = (r - l) * minHeight;
      if (area > maxArea) {
        maxArea = area;
      }
      if (heights[l] == minHeight) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }
}
