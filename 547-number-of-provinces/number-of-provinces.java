class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<n;i++){
            for(int j = 0; j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);

                }
            }
        }
        int count = 0;
        for(int i = 0 ; i <n;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                count++;
            }
        }
        return count;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis){
        vis[i] = true;
        for(Integer n : adj.get(i)){
            if(!vis[n]){
                dfs(adj,n,vis);
            }
        }
    }
}