import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
                continue;
            }

            if (stack.size() == 0) {
                return false;
            }

            switch (c) {
                case ']':
                    if (stack.removeFirst() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.removeFirst() != '{') {
                        return false;
                    }
                    break;
                default:
                    if (stack.removeFirst() != '(') {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}