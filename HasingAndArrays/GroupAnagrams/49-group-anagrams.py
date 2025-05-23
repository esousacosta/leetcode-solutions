class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            # I tried using repr() to conver the array
            # to its string representation, but it's slower
            # than converting the array to a tuple
            res[tuple(count)].append(s)
        return list(res.values())