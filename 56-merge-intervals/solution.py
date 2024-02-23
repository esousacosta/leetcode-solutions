class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        output = []
        
        intervals.sort()
        
        output.append(intervals[0])
        
        for i in range(1, len(intervals)):
            if intervals[i][0] <= output[-1][1]:
                output[-1] = [min(intervals[i][0], output[-1][0]), max(intervals[i][1], output[-1][1])]
            else:
                output.append(intervals[i])

        return output