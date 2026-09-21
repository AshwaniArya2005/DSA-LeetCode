class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i<nums.length;i++){
            sum+= nums[i];
        }
        if(sum %2 != 0 ) return false;
        sum /=2;
        int[][] dp = new int[nums.length][sum+1];
        for(int i = 0; i <nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(nums.length-1,sum,nums,dp);
    }
    
    boolean f(int index, int target, int[] nums,int[][] dp){
        if(target == 0) return true;
        if(index == 0) return target == 0 ? true : false;

        if(dp[index][target] != -1) return dp[index][target] == 1? true : false;

        boolean skip = f(index-1,target,nums,dp);
        boolean take = false;
        if(target >= nums[index]){
            take = f(index-1,target-nums[index],nums,dp);
        }
        boolean res = skip||take;
        dp[index][target] = res? 1 : 0;
        return res;
    }
}