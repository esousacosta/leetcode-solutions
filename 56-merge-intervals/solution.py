class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        output = []
        
        intervals.sort()
        
        output.append(intervals[0])
        
        for start, end in intervals[1:]:
            if start <= output[-1][1]:
                output[-1][1] = max(end, output[-1][1])
            else:
                output.append([start, end])

        return output