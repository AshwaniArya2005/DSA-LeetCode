class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1; 
        util(n, dp);
        return(dp[n]);
    }

    int util(int n, int[] dp) {
        if(n <= 1) return 1;

        if(dp[n] != -1 ) return dp[n];

        return dp[n] = util(n-1,dp) + util(n-2,dp) ;
    }
}