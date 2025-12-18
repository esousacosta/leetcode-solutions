class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int OFFSET = 10000;
        int RANGE = 20001;

        int[] freq = new int[RANGE];
        int maxFreq = 0;

        // Count frequencies
        for (int num : nums) {
            int idx = num + OFFSET;
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
        }

        // Buckets: index = frequency
        int[][] buckets = new int[maxFreq + 1][];
        int[] bucketSizes = new int[maxFreq + 1];

        // Count bucket sizes
        for (int f : freq) {
            if (f > 0)
                bucketSizes[f]++;
        }

        // Allocate buckets
        for (int i = 1; i <= maxFreq; i++) {
            buckets[i] = new int[bucketSizes[i]];
        }

        // Fill buckets
        int[] pos = new int[maxFreq + 1];
        for (int i = 0; i < RANGE; i++) {
            int f = freq[i];
            if (f > 0) {
                buckets[f][pos[f]++] = i - OFFSET;
            }
        }

        // Collect result
        int[] result = new int[k];
        int idx = 0;
        for (int f = maxFreq; f >= 1 && idx < k; f--) {
            for (int num : buckets[f]) {
                result[idx++] = num;
                if (idx == k)
                    break;
            }
        }

        return result;
    }
}
