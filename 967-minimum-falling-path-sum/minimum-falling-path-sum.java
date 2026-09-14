class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length;
        int[][] dp = new int[m][m];
        for(int i = 0; i <m;i++){
            dp[m-1][i] = matrix[m-1][i];
        }
        for(int i = m-2 ; i>=0;i--){
            for(int j = m-1; j>=0;j--){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(j-1>=0) left = matrix[i][j] + dp[i+1][j-1];
                if(j+1<m) right = matrix[i][j] + dp[i+1][j+1];
                int down = matrix[i][j] + dp[i+1][j];

                dp[i][j] = Math.min(down, Math.min(right, left));
            }
        }

        for(int i = 0; i <m;i++){
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }

    // int f(int[][] matrix, int i , int j, int[][] dp){
    //     if(i == matrix.length-1) return matrix[i][j];
    //     if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
    //     int right = Integer.MAX_VALUE;
    //     int left = Integer.MAX_VALUE;
    //     if(j+1 <matrix.length) right = matrix[i][j] + f(matrix,i+1,j+1,dp);
    //     if(j-1 >=0) left = matrix[i][j] + f(matrix,i+1,j-1,dp);
    //     int down = matrix[i][j] + f(matrix,i+1,j,dp);

    //     return dp[i][j] = Math.min(right, Math.min(down, left));
    // }
}