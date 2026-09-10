class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int p2 = 0;
        int p1 = 0;

        for(int i = 2; i <=cost.length;i++){
            int curr = Math.min(p2 + cost[i-2], p1 + cost[i-1]);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
}