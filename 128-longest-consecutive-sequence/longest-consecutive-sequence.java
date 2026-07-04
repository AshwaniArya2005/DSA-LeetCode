class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        Set<Integer> hs = new HashSet<>();
        int longest = 0;

        for(int i = 0; i<nums.length;i++){
            hs.add(nums[i]);
        }

        for(int i : hs){
            if(!hs.contains(i-1)){
                int currelem = i;
                int curr = 1;
                while(hs.contains(currelem+1)){
                    currelem++;
                    curr++;
                }
                longest = Math.max(longest,curr);
            }
        }

        return longest;
    }
}