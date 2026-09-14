class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        for(int i = 0; i < m;i++){
            dp[m-1][i] = triangle.get(m-1).get(i); 
        }
        for(int i = m-2;i>=0;i--){
            for(int j = i;j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diagonal);
            }
        }
        return dp[0][0];
        
    }

    // int f(List<List<Integer>> triangle, int i, int j, int[][] dp){
    //     if(i == triangle.size()-1) return triangle.get(i).get(j);
    //     if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
    //     int down = triangle.get(i).get(j) + f(triangle,i+1,j,dp);
    //     int diagonal = triangle.get(i).get(j) + f(triangle,i+1,j+1,dp);
        
    //     return dp[i][j] = Math.min(down, diagonal);
    // }
}