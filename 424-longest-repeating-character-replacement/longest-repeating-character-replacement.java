class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int maxfreq = 0;
        int maxwindow = 0;

        for(int r = 0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq,freq[s.charAt(r)-'A']);
            int windowlength = r-l+1;

            if(windowlength-maxfreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            windowlength = r-l+1;
            maxwindow = Math.max(maxwindow, windowlength);
        }
        return maxwindow;
    }
}