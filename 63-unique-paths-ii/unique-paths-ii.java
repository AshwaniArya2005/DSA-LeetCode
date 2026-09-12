class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i==0 && j==0) continue;

                int up = 0;
                int left = 0;
                if(i-1>=0) up = dp[i-1][j];
                if(j-1>=0) left = dp[i][j-1];

                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    
    }

    // int f(int m, int n, int[][] grid, int[][] dp) {
    //     if (m < 0 || n < 0)
    //         return 0;
    //     if (grid[m][n] == 1)
    //         return 0;
    //     if (m == 0 && n == 0)
    //         return 1;
    //     if(dp[m][n] != -1) return dp[m][n];
    //     return dp[m][n] =f(m - 1, n, grid,dp) + f(m, n - 1, grid);
    // }
}