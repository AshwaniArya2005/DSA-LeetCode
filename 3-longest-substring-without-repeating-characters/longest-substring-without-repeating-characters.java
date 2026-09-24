class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int count = 0;
        while(j!=s.length()){
            while(hs.contains(s.charAt(j))){
                hs.remove(s.charAt(i));
                i++;
                count--;
            }
            hs.add(s.charAt(j));
            count++;
            maxCount = Math.max(count, maxCount);
            j++;
        }
        return maxCount;
    } 
}