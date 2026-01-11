    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;

            int[] freq = new int[26];

            for (char c : s1.toCharArray())
                freq[c - 'a']++;

            int remaining = s1.length();
            int left = 0;

            for (int right = 0; right < s2.length(); right++) {
                char r = s2.charAt(right);

                if (freq[r - 'a'] > 0) {
                    remaining--;
                }

                freq[r - 'a']--;

                if (right - left + 1 > s1.length()) {
                    char l = s2.charAt(left);
                    
                    // if this is not true, we still
                    // have "spare" of this letter to use inside
                    // the current window
                    if (freq[l - 'a'] >= 0) {
                        remaining++;
                    }

                    freq[l - 'a']++;
                    left++;
                }

                if (remaining == 0)
                    return true;
            }

            return false;
        }

        private void clearArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
        }
    }