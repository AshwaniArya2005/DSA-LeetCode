class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            al.add(new ArrayList<>());
        }
        addEdge(al,edges);
        boolean[] vis = new boolean[al.size()];
        if(dfs(source,al, destination, vis)){
            return true;
        }
        return false;
    }

    public void addEdge(ArrayList<ArrayList<Integer>> al, int[][] edges){
        for(int[] edge : edges){
            al.get(edge[0]).add(edge[1]);
            al.get(edge[1]).add(edge[0]);
        }
    }

    public boolean dfs(int source, ArrayList<ArrayList<Integer>> al, int dest, boolean[] vis){
        if(source == dest){
            return true;
        }
        vis[source] = true;

        for(int n : al.get(source)){
            if(!vis[n] && dfs(n,al,dest,vis)){
                return true;
            }
        }
        return false;
    }
}