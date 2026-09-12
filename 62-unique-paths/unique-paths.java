class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <m;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0] = 0;
        return f(m-1,n-1,dp);
    }
    int f(int m, int n, int[][] dp){
        if(m <= 0 || n<=0) return 1;

        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = f(m-1,n,dp) + f(m,n-1,dp) ;
    }
}