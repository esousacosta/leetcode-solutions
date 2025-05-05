class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if len(nums1) == 1:
            nums1[0 : len(nums2)] = nums2
            return
        elif len(nums2) == 0:
            return

        i = m + n - 1
        r = n - 1
        l = m - 1

        while l >= 0 and r >= 0:
            if nums1[l] >= nums2[r]:
                nums1[i] = aux[l]
                l -= 1
            else:
                nums1[i] = nums2[r]
                r -= 1
            i -= 1

        if l == 0:
            nums1[0 : i + 1] = nums2[0 : r + 1]
        elif r == 0:
            # we don't want to include the zeros at the end of the
            # first array.
            nums1[0 : i + 1] = aux[0 : l + 1]
