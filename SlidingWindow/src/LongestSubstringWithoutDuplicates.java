import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {
  public int lengthOfLongestSubstring(String s) {
    int longest = 0;
    Map<Character, Integer> currSubstring = new HashMap<>();
    int r = 0;
    while (r < s.length()) {
      if (currSubstring.containsKey(s.charAt(r))) {
        if (currSubstring.size() > longest) {
          longest = currSubstring.size();
        }
        int duplicate = currSubstring.get(s.charAt(r));
        for (int i = r - currSubstring.size(); i <= duplicate; i++) {
          currSubstring.remove(s.charAt(i));
        }
      }
      currSubstring.put(s.charAt(r), r);
      r++;
    }
    return Integer.max(currSubstring.size(), longest);
  }

  //VERY NEET!!!
  public int solution(String s) {
    HashSet<Character> charSet = new HashSet<>();
    int l = 0;
    int res = 0;

    for (int r = 0; r < s.length(); r++) {
      while (charSet.contains(s.charAt(r))) {
        charSet.remove(s.charAt(l));
        l++;
      }
      charSet.add(s.charAt(r));
      res = Math.max(res, r - l + 1);
    }
    return res;
  }
}
