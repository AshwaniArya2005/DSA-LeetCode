class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] psum = new int[nums.length];
        int[] ssum = new int[nums.length];
        // psum[0] =1;
        Arrays.fill(psum,1);
        for(int i = 1; i<nums.length;i++){
            psum[i]= nums[i-1]*psum[i-1];
        }
        // ssum[nums.length-1] = 1;
        Arrays.fill(ssum,1);
        for(int i = nums.length-2; i>=0;i--){
            ssum[i] = nums[i+1]*ssum[i+1];
        }

        int[] res = new int[nums.length];
        res[0] = ssum[0];
        res[nums.length-1] = psum[nums.length-1];
        for(int i = 1;i<nums.length-1;i++){
            res[i] = psum[i]*ssum[i];
        }

        return res;
    }
}