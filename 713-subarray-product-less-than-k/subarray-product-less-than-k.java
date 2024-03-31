class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = 1;
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k && start <= i) {
                product /= nums[start];
                start++;
            }
            count += (i - start + 1);
        }
        return count;
    }
}