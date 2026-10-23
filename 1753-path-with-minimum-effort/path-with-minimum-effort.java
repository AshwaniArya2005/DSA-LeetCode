class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int dist[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        dist[0][0] = 0;
        pq.offer(new int[]{0,0,0});

        int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1}
        };
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == m-1 && c ==  n-1){
                return effort;
            }

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr <m  && nc >= 0 && nc <n){
                    int edgeEffort = Math.abs(heights[r][c] - heights[nr][nc]);
                    int newEffort = Math.max(effort,edgeEffort);
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }

            
        }
        return 0;
    }
}