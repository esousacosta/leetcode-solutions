import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.computeIfAbsent(num, n -> 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : frequencyMap.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] result = new int[k];
        int resultIdx = 0;

        for (int i = nums.length; i > 0 && resultIdx < k; i--) {
            for (int num : buckets[i]) {
                result[resultIdx] = num;
                resultIdx++;

                if (resultIdx >= k) {
                    break;
                }
            }
        }

        return result;
    }
}