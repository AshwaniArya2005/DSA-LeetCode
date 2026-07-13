class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> b[0]-a[0]);
        // Map<Integer, Integer[]> hm = new HashMap<>();
        for(int i = 0; i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            int distance = x*x + y*y;

            pq.add(new int[] {distance, x, y});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;

        while(i<k){
            int[] curr = pq.poll();
            res[i][0] = curr[1];
            res[i][1] = curr[2];

            i++;
        }
        return res;

    }
}