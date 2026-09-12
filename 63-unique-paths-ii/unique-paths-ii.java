class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(m-1,n-1, grid, dp);
    }

    int f(int m, int n, int[][] grid, int[][] dp) {
        if (m < 0 || n < 0)
            return 0;
        if (grid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] =f(m - 1, n, grid,dp) + f(m, n - 1, grid,dp);
    }
}