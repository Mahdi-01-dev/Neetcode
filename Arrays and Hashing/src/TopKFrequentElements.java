import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    Map<Integer, ArrayList> reverseFreqMap = new HashMap<>();
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      int frequency = entry.getValue();
      if (!reverseFreqMap.containsKey(frequency)) {
        reverseFreqMap.put(frequency, new ArrayList<>());
      }
      reverseFreqMap.get(frequency).add(entry.getKey());
    }
    int[] result = new int[k];
    int index = 0;
    int freq = nums.length;
    while (k > 0) {
      if (reverseFreqMap.containsKey(freq)) {
        List<Integer> list = reverseFreqMap.get(freq);
        for (int num : list) {
          result[index] = num;
          index++;
        }
        k -= list.size();
      }
      freq--;
    }
    return result;
  }
}
