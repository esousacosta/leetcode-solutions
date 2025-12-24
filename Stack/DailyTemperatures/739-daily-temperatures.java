import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                int prevIdx = stack.removeFirst();
                out[prevIdx] = i - prevIdx;
            }

            stack.addFirst(i);
        }

        return out;
    }
}