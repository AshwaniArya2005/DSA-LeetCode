class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : flights){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            adj.get(u).add(new int[] {v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        
        int[][] dist = new int[n][k+2];
        for(int i = 0 ; i < n ;i++){

            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        pq.offer(new int[]{0,src,0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int c = curr[1];
            int s = curr[2];

            if(c == dst){
                return d;
            }

            if(s > k) continue;

            for(int[] nh : adj.get(c)){
                int nc = nh[0];
                int price = nh[1];

                if(price + d < dist[nc][s+1]){
                    dist[nc][s+1] = price+d; 
                    pq.offer(new int[]{d+price, nc, s+1});
                }
            }
        }

        return -1;


        
    }
}