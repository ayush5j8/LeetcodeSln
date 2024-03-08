class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length)
        return -1;
        int dp[][] = new int[d+1][jobDifficulty.length+1];
        for(int i =0; i<=d;i++)
        Arrays.fill(dp[i], -1);

        return solve(dp,jobDifficulty,jobDifficulty.length,d,0);
    }
    private int solve(int dp[][], int[] jd, int n, int d, int idx){
        int max = jd[idx];
        int min = Integer.MAX_VALUE;
        if(d == 1){
            for(int i=idx;i<n;i++)
            max = Math.max(jd[i], max);
            return max;
        }

        if(dp[d][idx]!=-1)
        return dp[d][idx];

        for(int i=idx;i<=n-d;i++){
            max = Math.max(jd[i],max);
            int ans = max+solve(dp,jd,n,d-1,i+1);
            min = Math.min(min,ans);
        }
        dp[d][idx] = min;
        return dp[d][idx];
    }
}