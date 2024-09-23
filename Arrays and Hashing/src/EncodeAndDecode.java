import java.util.*;

public class EncodeAndDecode {
  public String encode(List<String> strs) {
    String result = "";
    for (String str : strs) {
      result += str.length() + "#" + str;
    }
    return result;
  }

  public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#') {
        j++;
      }
      int length = Integer.valueOf(str.substring(i, j));
      i = j + length + 1;
      result.add(str.substring(j + 1, i));
    }
    return result;
  }
}
