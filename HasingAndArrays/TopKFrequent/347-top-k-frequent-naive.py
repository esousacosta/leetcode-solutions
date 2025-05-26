class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        seen = defaultdict(lambda: 0)
        output = set()

        for num in nums:
            seen[num] += 1

        sortedSeen = dict(sorted(seen.items(), key=lambda item: item[1], reverse=True))

        return list(sortedSeen.keys())[:k]
