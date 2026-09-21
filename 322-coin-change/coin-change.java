class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0 ; i <coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = f(coins.length-1, amount, coins, dp);
        return ans == 1e9? -1 : ans;
    }

    int f(int index, int target, int[] coins, int[][] dp){
        if(target == 0) return 0;
        if(index == 0) {
            if(target % coins[index] == 0) return target /coins[index];
            else return (int)1e9;
        }
        if(dp[index][target]!= -1) return dp[index][target];

        int skip = 0 + f(index-1,target,coins,dp);
        int take = Integer.MAX_VALUE;
        if(target >= coins[index]){
            take = 1 + f(index,target -coins[index],coins,dp);
        }
        return dp[index][target] = Math.min(skip,take);
    }
}