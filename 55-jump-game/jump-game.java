class Solution {
    public boolean canJump(int[] nums) {
        if(check(nums)) return true;
        int maxReach = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(i>maxReach) return false;

            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach >= nums.length-1){
                return true;
            }
        }
        return true;
    }
    boolean check(int[] nums){
        for(int i : nums){
            if(i == 0) return false;
        }
        return true;
    }
}