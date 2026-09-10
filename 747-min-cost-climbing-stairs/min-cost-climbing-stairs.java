class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp  = new int[n+1];
        Arrays.fill(dp,-1);
        return util(cost,dp,n);

    }

    int util(int[] cost, int[] dp, int i){
        if(i <= 1) return 0;
        if(dp[i] != -1 ) return dp[i];
        return dp[i] = Math.min(util(cost,dp,i-1)+cost[i-1], util(cost,dp,i-2)+cost[i-2]);
    }
}