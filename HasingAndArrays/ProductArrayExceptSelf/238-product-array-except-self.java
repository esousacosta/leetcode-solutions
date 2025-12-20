class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int zeroIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroIdx != -1) {
                zeroIdx = i;
                continue;
            } else if (nums[i] == 0) {
                return new int[nums.length];
            }

            totalProduct *= nums[i];
        }

        if (zeroIdx != -1) {
            int[] result = new int[nums.length];
            result[zeroIdx] = totalProduct;
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = totalProduct / nums[i];
        }

        return nums;
    }
}  
