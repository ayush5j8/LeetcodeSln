class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = (int) Math.pow(2, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        
        return res;
    }
}