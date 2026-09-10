class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        return util(nums,dp,n-1);
    }

    int util(int[] nums, int[] dp, int n){
        if(n <= 0) return nums[0];

        if(dp[n] != -1) return dp[n];

        int skip = util(nums,dp,n-1);
        int take = util(nums, dp,n-2) + nums[n];
        return dp[n] = Math.max(skip,take);
    }
}