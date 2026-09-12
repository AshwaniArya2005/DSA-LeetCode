class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0; i <m;i++){
            for(int j = 0; j<n;j++){
                if(i==0 && j==0) continue;
                int up = (int) 10e9;
                int left =(int) 10e9;
                if(i-1>=0) up = dp[i-1][j];
                if(j-1>=0) left= dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
        
    }
    // int f(int m, int n, int[][] grid,int[][] dp){
    //     if(m==0 && n==0) return grid[0][0];
    //     if(m< 0 || n<0) return Integer.MAX_VALUE;
    //     if(dp[m][n] != -1) return dp[m][n];
    //     return dp[m][n] = grid[m][n]+Math.min(f(m-1,n,grid,dp),f(m,n-1,grid,dp));
    // }
}