class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj  =new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        if(dfs(adj, source, destination, vis)){
            return true;
        }
        return false;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, boolean[] vis){
        if(src == dest){
            return true;
        }
        vis[src] = true;

        for(int i : adj.get(src)){
            if(!vis[i]){
                if(dfs(adj,i,dest,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}