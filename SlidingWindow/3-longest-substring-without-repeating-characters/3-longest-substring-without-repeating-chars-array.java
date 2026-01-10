import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] seen = new int[128];
        int l = 0;
        int n = s.length();

        for(int r = 0; r < n; r++) {
            char c = s.charAt(r);

            // Move left pointer if the character was
            // last seen inside the current window
            l = Math.max(l, seen[c]);

            maxLength = Math.max(maxLength, r - l + 1);
            
            // Add one position ahead of the current to tell
            // the block above where to properly move l to.
            seen[c] = r + 1;
        }

        return maxLength;
    }
}