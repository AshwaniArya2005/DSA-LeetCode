class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i <isConnected.length;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int v, boolean[] vis, int[][] isConnected){
        vis[v] = true;
        for(int j = 0;j<isConnected[v].length;j++){
            if(!vis[j] && isConnected[v][j] == 1){
                dfs(j,vis,isConnected);
            }
        }
    }
}