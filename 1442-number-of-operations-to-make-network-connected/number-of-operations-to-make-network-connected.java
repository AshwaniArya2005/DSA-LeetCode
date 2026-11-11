class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        DSU dsu = new DSU(n);
        int result = n;
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            if(dsu.find(u) == dsu.find(v)){
                continue;
            }
            else{
                dsu.join(u,v);
                result--;
            }
        }
        return result-1;
    }

    class DSU{
        int[] parent, rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i <n;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void join(int x, int y){
            int px = find(x);
            int py = find(y);
            if (px==py) return;
            if(rank[px] > rank[py]) parent[py] = px;
            else if(rank[px] < rank[py]) parent[px] = py;
            else{
                parent[px] = py;
                rank[px]++;
            }
        }
    }
} 