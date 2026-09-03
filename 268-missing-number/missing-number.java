class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i<nums.length;i++){
            st.add(nums[i]);
        }

        for(int i = 0; i<=nums.length;i++){
            if(!st.contains(i)){
                return i;
            }
        }
        return -1;
    }
}