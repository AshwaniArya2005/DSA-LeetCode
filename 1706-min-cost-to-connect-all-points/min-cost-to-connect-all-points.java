class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        pq.offer(new int[] {0,0});
        int sum = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if(vis[node]) continue;
            vis[node] = true;
            sum+= d;
            for(int i =0 ; i<n;i++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[node][0];
                int y2 = points[node][1];

                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                pq.offer(new int[]{dist,i});
            }
        }
        return sum;
    }
}