class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] a = new int[2];
        for(int i = 0; i<nums.length;i++){
            int need = target - nums[i];
            if(hm.containsKey(need)){
                a[0] = hm.get(need);
                a[1] = i;
                break;
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return a;
    }
}