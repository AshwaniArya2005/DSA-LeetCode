class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i <m;i++) Arrays.fill(dp[i],-1);
        return f(m-1,n-1,grid,dp);
    }
    int f(int m, int n, int[][] grid,int[][] dp){
        if(m==0 && n==0) return grid[0][0];
        if(m< 0 || n<0) return Integer.MAX_VALUE;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = grid[m][n]+Math.min(f(m-1,n,grid,dp),f(m,n-1,grid,dp));
    }
}