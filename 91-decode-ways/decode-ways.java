class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1)
            return s.charAt(0) == '0' ? 0 : 1;
        
        int[] dp = new int [s.length()];
        Arrays.fill(dp,-1);
        return util(s, 0,dp);
    }

    // int ways = 0;
    int util(String s, int i,int[] dp){
        if(i== s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];
        int ways = util(s,i+1,dp);
        
        if(i+1<s.length()){
            int sb = (s.charAt(i)- '0')*10+(s.charAt(i+1) - '0');
            if(sb>=10 && sb<=26){
               
                ways += util(s,i+2,dp);
            }

        } 
        
        return dp[i] = ways;
        
    }
}