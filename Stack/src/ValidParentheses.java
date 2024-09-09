import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> closed = new Stack<>();
    Map<Character, Character> bracketPairs = new HashMap<>();
    bracketPairs.put('[', ']');
    bracketPairs.put('{', '}');
    bracketPairs.put('(', ')');
    for (Character c : s.toCharArray()) {
      if (bracketPairs.containsKey(c)) {
        closed.push(bracketPairs.get(c));
      } else if (closed.isEmpty() || closed.pop() != c) {
          return false;
      }
    }
    return closed.isEmpty();
  }
}
