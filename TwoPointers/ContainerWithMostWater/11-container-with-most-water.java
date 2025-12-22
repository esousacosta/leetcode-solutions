class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxA = Integer.MIN_VALUE;

        while (l < r) {
            int leftVal = height[l];
            int rightVal = height[r];
            int area = (r - l) * Math.min(leftVal, rightVal);
            if (area > maxA) {
                maxA = area;
            }

            if (leftVal < rightVal) {
                l++;
            } else {
                // The choice to move r if they're of the same height is arbitrary
                r--;
            }
        }

        return maxA;

    }
}