class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] i : prerequisites){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] rs = new boolean[numCourses];
        for(int i = 0; i <numCourses;i++){
            if(!vis[i]){
                if(dfs(adj,i,vis,rs)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int i , boolean[] vis, boolean[] rs){
        vis[i] = true;
        rs[i] = true;

        for(Integer n: adj.get(i)){
            if(!vis[n]){
                if(dfs(adj,n,vis,rs)){
                    return true;
                }
            }
            else if(rs[n]){
                return true;
            }
        }
        rs[i] = false;
        return false;
    }
}