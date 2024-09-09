import java.util.*;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedStr = new String(charArray);
      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<>());
      }
      map.get(sortedStr).add(str);
    }
    return new ArrayList<>(map.values());
  }

  // Instead of using sorting for the keys which is nlog(n) at best, we use a linear approach
  public List<List<String>> solution(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      int[] count = new int[26];
      for (char chr : str.toCharArray()) {
        count[chr - 'a']++;
      }

      String key = Arrays.toString(count);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }
    return new ArrayList<>(map.values());
  }
}
