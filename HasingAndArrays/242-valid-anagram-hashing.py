class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(t) != len(s):
            return False

        seen = {}
        for c in s:
            if c not in seen:
                seen[c] = 1
            else:
                seen[c] += 1

        for c in t:
            if c not in seen:
                return False
            seen[c] -= 1

        for val in seen.values():
            if val != 0:
                return False

        return True