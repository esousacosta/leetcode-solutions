class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        nLen = len(needle)
        hLen = len(haystack)
        if nLen > hLen:
            return -1
        elif hLen == nLen:
            return 0 if haystack == needle else -1

        # If range was inclusive on the right edge,
        # we wouldn't need to sum 1 to it.
        for l in range(0, hLen - nLen + 1):
            if haystack[l : l + nLen] == needle:
                return l

        return -1
