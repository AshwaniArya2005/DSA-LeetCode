class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : times){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            adj.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[] {0,k});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(d!=dist[u]) continue;

            for(int[] edge : adj.get(u)){
                int v = edge[0];
                int w = edge[1];

                if(d+w <dist[v]){
                    dist[v] = d+w;
                    pq.offer(new int[] {dist[v],v});
                }
            }
        }
        int maxDelay = 0;
        for(int i = 1; i <=n;i++){
            if(dist[i] == (int) 1e9){
                return -1;
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}