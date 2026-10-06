class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] indeg = new int[n];

        for(int[] i: relations){
            int u = i[0]-1;
            int v = i[1]-1;
            adj.get(u).add(v);
            indeg[v]++;
        }

        int[] dp = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<n;i++){
            if(indeg[i] == 0){
                q.offer(i);
                dp[i] = time[i];
            } 
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : adj.get(curr)){
                dp[next] = Math.max(dp[next] , dp[curr]+time[next]);
                indeg[next]--;

                if(indeg[next]== 0) q.offer(next);
            }
        }

        int ans = 0;
        for(int i = 0; i <n;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;

    }
}