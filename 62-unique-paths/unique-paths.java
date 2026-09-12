class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i <m;i++){
            int[] temp = new int[n];
            temp[0] = 1;
            for(int j = 0; j<n;j++){
                if(i-1>=0 && j-1>=0){
                    temp[j] = dp[j] + temp[j-1];
                }else if(i-1 <0 && j-1 >=0){
                    temp[j] = temp[j-1];
                }else if(j-1 <0 && i-1>=0){
                    temp[j] = dp[j];
                }
                
            }
            dp = temp;
        }
        return dp[n-1];
    }
}