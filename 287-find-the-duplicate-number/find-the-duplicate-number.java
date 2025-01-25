class Solution {
    public int findDuplicate(int[] nums) {
        // linked list approach
        int turt = nums[0], hare = nums[0];
        do { 
            turt = nums[turt];
            hare = nums[nums[hare]];
            } 
        while(turt != hare);
        hare = nums[0];
        while(turt != hare) {
            turt = nums[turt];
            hare = nums[hare];
        }
        return hare;
    }
}