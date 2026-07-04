class Solution {
    public int findMaxLength(int[] nums) {
        int[] psum = new int[nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                sum-=1;
            }else{
                sum+=1;
            }
            psum[i] = sum;
        }

        Map<Integer, Integer> hm = new HashMap<>();
        int maxcount = 0;
        hm.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            

            if(hm.containsKey(psum[i])){
                int count = i-hm.get(psum[i]);
                maxcount = Math.max(maxcount, count);
            }
            else{
                hm.put(psum[i],i);
            }
        }
        return maxcount;
    }
}