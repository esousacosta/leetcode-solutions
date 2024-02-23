class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        output = 0

        intervals.sort()

        previousEnd = intervals[0][1]

        for start, end in intervals[1:]:
            if start < previousEnd:
                previousEnd = min(previousEnd, end)
                output += 1
            else:
                previousEnd = end

        return output