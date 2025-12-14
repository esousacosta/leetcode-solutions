class solution:
    def search(nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        l = 0
        m = math.ceil(len(nums) / 2) - 1
        r = len(nums) - 1
        while true:
            if nums[m] == target:
                return m
            # The target is not in the list since
            # it's outside of the sorted boundaries
            if target < l or target > r:
                return -1
            if target > nums[m]:
                l = m + 1
            else:
                r = m - 1
            m = l + math.floor((r - l) / 2)
