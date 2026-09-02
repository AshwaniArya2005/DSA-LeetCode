class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        return Math.max(util(nums,0,nums.length-2),util(nums,1,nums.length-1));
    }

    public int util(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int n = nums.length;
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0],nums[start+1]);
        int j = 2;
        for(int i = start+2;i<=end;i++){
            dp[j] = Math.max(dp[j-1],dp[j-2]+nums[i]);
            j++;
        }
        return dp[end-start];
    }
}