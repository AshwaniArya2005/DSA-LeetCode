class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);

        for(int i = 0; i<graph.length;i++){
            if(color[i] == -1){
                if(!dfs(i,graph, color,0)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int v, int[][] graph, int[] color, int currcolor){
        color[v] = currcolor;

        for(int n : graph[v]){
            if(color[n] == -1){
                if(!dfs(n,graph, color, 1-currcolor)){
                    return false;
                }
            }else if(color[n] == currcolor){
                return false;
            }
        }
        return true;
    }

}