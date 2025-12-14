import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // The size of the string must be pair for each element to
        // have a corresponding closing one.
        if (s.length() % 2 != 0) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.addFirst(c);
                continue;
            }

            if (stack.isEmpty()) {
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