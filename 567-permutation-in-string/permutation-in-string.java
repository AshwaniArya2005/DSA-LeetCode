class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        if(s1.length()>s2.length()) return false;

        for(int i= 0 ;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
        }

        int i = 0, j = s1.length()-1;
        for(int k = 0;k <j+1;k++){
            freq2[s2.charAt(k)-'a']++;
        }
        while(j<=s2.length()-1){
            boolean flag = true;
            for(int k = 0;k<freq1.length;k++){
                if(freq1[k]!=freq2[k]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                return true;
            }
            freq2[s2.charAt(i)-'a']--;
            i++;
            if(j==s2.length()-1){
                break;
            }
            j++;
            freq2[s2.charAt(j)-'a']++;
        }
        return false;

        

    }
}