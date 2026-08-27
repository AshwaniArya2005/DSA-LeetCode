class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int[][] dp = new int[2001][2001];
    int n;
    public boolean canCross(int[] stones) {
        n = stones.length;
        for(int i = 0;i<n;i++){
            hm.put(stones[i],i);
        }

        for(int i = 0;i<2001;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(stones, 0, 0, dp);
    }

    public boolean solve(int[] stones, int curr, int prev, int[][] dp){
        if(curr == n-1){
            return true;
        }
        if(dp[curr][prev] != -1){
            return dp[curr][prev]==1;
        }
        boolean result = false;

        for(int i = prev-1; i<=prev+1;i++){
            if(i>0){
                int next = i+stones[curr];
                if(hm.containsKey(next)){
                    result = result || solve(stones,hm.get(next),i,dp);
                }
            }
        }

        dp[curr][prev] = result ? 1:0;
        return result;
    }
}