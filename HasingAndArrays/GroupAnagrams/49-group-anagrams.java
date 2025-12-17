import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs));
        }

        Map<String, List<String>> result = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String key = new String(count);

            result.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(str);

        }

        return new ArrayList<>(result.values());
    }
}