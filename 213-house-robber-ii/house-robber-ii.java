class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int first = util(nums, nums.length-1,1,dp);

        Arrays.fill(dp,-1);
        int last = util(nums,nums.length-2,0,dp);

        return Math.max(first, last);
    }

    public int util(int[] nums, int i, int end, int[] dp){
        if(i<end) return 0;

        if(dp[i]!=-1) return dp[i];

        int skip = util(nums,i-1,end,dp);
        int rob = util(nums,i-2,end,dp) + nums[i];
        return dp[i] = Math.max(skip,rob);
    }
}