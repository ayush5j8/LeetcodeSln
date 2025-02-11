class Solution {
    public boolean canJump(int[] nums) {
        // check from n-1 to 0
        // for every i we check if its possible to got to the next position
        int canJumpIdx = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(i+nums[i]>= canJumpIdx)
            canJumpIdx = i;
        }
        return canJumpIdx == 0;
    }
}