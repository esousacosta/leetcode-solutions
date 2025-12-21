class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;

        // left to right (prefix)
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Right to left (suffix)
        int suffixProd = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] *= suffixProd;
            suffixProd *= nums[i];
        }

        return output;
    }
}  
