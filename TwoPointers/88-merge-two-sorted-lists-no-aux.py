class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        """"
        Trick: start filling the list from the end to the beginning
        """
        if len(nums1) == len(nums2):
            nums1[:] = nums2
            return
        elif len(nums2) == 0:
            return

        target = m + n - 1
        l = m - 1
        r = n - 1

        while l >= 0 and r >= 0:
            if nums1[l] >= nums2[r]:
                nums1[target] = nums1[l]
                l -= 1
            else:
                nums1[target] = nums2[r]
                r -= 1

            target -= 1

        if l < 0:
            nums1[: target + 1] = nums2[: r + 1]
