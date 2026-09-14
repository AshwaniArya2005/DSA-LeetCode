class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length;
        int[][] dp = new int[m][m];
        for(int i = 0; i <m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i = 0 ; i<matrix.length;i++){
            min = Math.min(min,f(matrix, 0,i,dp));
        }
        return min;
    }

    int f(int[][] matrix, int i , int j, int[][] dp){
        if(i == matrix.length-1) return matrix[i][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(j+1 <matrix.length) right = matrix[i][j] + f(matrix,i+1,j+1,dp);
        if(j-1 >=0) left = matrix[i][j] + f(matrix,i+1,j-1,dp);
        int down = matrix[i][j] + f(matrix,i+1,j,dp);

        return dp[i][j] = Math.min(right, Math.min(down, left));
    }
}