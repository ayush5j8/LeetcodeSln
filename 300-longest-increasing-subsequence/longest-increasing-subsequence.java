class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> tm = new TreeSet<>();
        tm.add(nums[0]);
        for(int e:nums){
            Integer ceilValue = tm.ceiling(e);
            if(ceilValue == null)
            tm.add(e);
            else{
                tm.remove(ceilValue);
                tm.add(e);
            }
        }
        return tm.size();
    }
}