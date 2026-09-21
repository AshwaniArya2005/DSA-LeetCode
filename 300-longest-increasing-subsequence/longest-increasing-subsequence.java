class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i = 0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,-1,nums,dp);  
    } 
    int f(int index, int prev, int[] nums, int[][] dp){
        if(index > nums.length-1) return 0;

        if(dp[index][prev+1]!= -1) return dp[index][prev+1];
        int skip = 0 + f(index+1,prev,nums,dp);
        int take = Integer.MIN_VALUE;
        if(prev == -1 || nums[index] > nums[prev]){
            take = 1 + f(index+1,index,nums,dp);
        }
        return dp[index][prev+1] = Math.max(skip,take);
    }
}