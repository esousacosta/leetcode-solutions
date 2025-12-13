import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        // lowercase letters: 0x61 --> 0x7A
        if (s.equals(t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[] letters = new int[26];

        for (int i = 0; i < len; i++) {
            letters[sArray[i] - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (letters[tArray[i] - 'a'] == 0) {
                return false;
            }

            letters[tArray[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] < 0) {
                return false;
            }
        }

        return true;
    }
}