class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        seen = defaultdict(lambda: 0)
        output = []

        for num in nums:
            seen[num] += 1

        buckets = defaultdict(list)

        maxCount = 0
        for num, count in seen.items():
            if count > maxCount:
                maxCount = count
            buckets[count].append(num)

        taken = 0
        while True:
            if len(buckets[maxCount]) < (k - taken):
                # extend prevents having a list inside another one
                # (append would do that)
                output.extend(buckets[maxCount])
                taken += len(buckets[maxCount])
                maxCount -= 1
            else:
                output.extend(buckets[maxCount][: k - taken])
                return output
