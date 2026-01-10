import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        int maxLength = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        int l = 0;
        int n = s.length();

        for(int r = 0; r < n; r++) {
            char c = s.charAt(r);

            // Move left pointer if the character was
            // last seen inside the current window
            if (seen.containsKey(c))
                l = Math.max(l, seen.get(c) + 1);

            maxLength = Math.max(maxLength, r - l + 1);
            
            seen.put(c, r);
        }

        return maxLength;
    }
}