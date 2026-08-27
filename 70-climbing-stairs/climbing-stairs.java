class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        return(cS(n ,dp));
    }

    public int cS(int n, int[] dp){
        if(n == 0){
            return 0;
        }
        if(dp[n]!= -1){
            return dp[n];
        }
        // return dp[n] = 1+ Math.max(dp[n-1],dp[n-2]);
        return dp[n] =  cS(n-1,dp) + cS(n-2,dp);
    }
}