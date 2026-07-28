class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] rs = new boolean[numCourses];

        for(int i = 0; i <numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i <prerequisites.length;i++){
            addEdge(adj,prerequisites, i);
        }

        for(int i = 0; i <adj.size();i++){
            if(dfs(i, adj,vis,rs)){
                return false;
            }
        }
        return true;

    }

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int[][] pre, int i ){
        int from = pre[i][1];
        int to = pre[i][0];

        adj.get(from).add(to);
    }

    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] rs){
        vis[v] = true;
        rs[v] = true;
        for(Integer n : adj.get(v)){
            if(rs[n]) return true;
            if(!vis[n]){
                if(dfs(n, adj,vis,rs)){
                    return true;
                }
            }
        }
        rs[v] = false;
        return false;
    }
}