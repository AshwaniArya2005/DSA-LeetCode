class Solution {
    public boolean canJump(int[] nums) {
        if(check(nums)) return true;
        int reach = 0;
        for(int i = 0 ; i <nums.length;i++){
            if(i>reach) return false;

            reach = Math.max(reach,i+nums[i]);
            if(reach >= nums.length-1){
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