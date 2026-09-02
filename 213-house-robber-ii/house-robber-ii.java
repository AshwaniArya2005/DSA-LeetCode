class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int first = util(nums,0,nums.length-2);
        int last = util(nums,1,nums.length-1);

        return Math.max(first,last);

    }

    public int util(int[] nums, int i, int end){
        int prev2 = 0;
        int prev1 = 0;

        for(int j = i; j<=end;j++){
            int curr = Math.max(prev1,prev2 + nums[j]);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}