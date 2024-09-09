import java.util.*;

public class GenerateParentheses {
  private Set<String> result = new HashSet<>();
  public List<String> generateParenthesis(int n) {
    recurse("(", 1, 0, n);
    return result.stream().toList();
  }

  private void recurse(String str, int opened, int closed, int n) {
    if (opened < n) {
      if (closed < opened) {
        int newClosed = closed + 1;
        recurse(str + ')', opened, newClosed, n);
      }
      recurse(str + '(', ++opened, closed, n);
    } else {
      for (int i = 0; i < n - closed; i++) {
        str += ')';
      }
      result.add(str);
    }
  }
}
