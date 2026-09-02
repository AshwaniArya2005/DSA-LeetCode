class Solution {
    public int rob(int[] nums) {
        int[] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        return util(nums,nums.length-1,dp);
    }

    public int util(int[] nums, int i, int[] dp ){
        if(i<0) return 0;

        if(dp[i] != -1) return dp[i];
        int skip = util(nums,i-1,dp);
        int rob = util(nums,i-2,dp)+nums[i];

        return dp[i] = Math.max(skip,rob);

    }
}