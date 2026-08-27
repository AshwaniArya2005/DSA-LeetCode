class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        return fibo(n, dp);

    }

    public int fibo(int n, int[] dp){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];
        return dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
    }
}