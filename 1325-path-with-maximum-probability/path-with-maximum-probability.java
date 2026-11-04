class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();
        for(int i = 0; i <n;i++){
            adj.add(new ArrayList<double[]>());
        }

        for(int i = 0 ; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new double[]{v,w});
            adj.get(v).add(new double[]{u,w});
        }

        PriorityQueue<double[]> pq= new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));

        double[] dist = new double[n];
        // Arrays.fill(dist,Integer.MIN_VALUE);
        dist[start_node] = 1.0;

        pq.offer(new double[]{1.0,start_node});

        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            double prob = curr[0];
            int node = (int)curr[1];

            if(prob < dist[node]) continue;
            // if(node = end_node) return prob;
            for(double edge[]:adj.get(node)){
                int neigh = (int) edge[0];
                double ep = edge[1];
                double np = ep*prob;

                if(np>dist[neigh]){
                    dist[neigh] = np;
                    pq.offer(new double[]{np,neigh});
                }

            }
        }
        return dist[end_node];
    }

}