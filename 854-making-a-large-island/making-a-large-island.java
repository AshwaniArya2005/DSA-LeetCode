class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int id = 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,0);
        boolean flag = false;
        for(int i = 0; i < m;i++){
            for(int j = 0 ; j <n ; j++){
                if(grid[i][j] == 0) flag = true;
                if(!vis[i][j] && grid[i][j] == 1){
                    dfs(grid,vis,i,j,id,hm);
                    id++;
                }
            }
        }
        int maxCount = 0;
        if(!flag){
            for(int i : hm.values()){
                maxCount= Math.max(maxCount, i);
            }
            return maxCount;
        }
        for(int i = 0; i <m;i++){
            for(int j = 0 ; j<n;j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> hs = new HashSet<>();
                    int up =0 , down= 0,left=0,right=0;

                    if(i+1<m) up = grid[i+1][j];
                    if(i-1>=0) down = grid[i-1][j];
                    if(j-1>=0) left = grid[i][j-1];
                    if(j+1<n) right = grid[i][j+1];
                    hs.add(up);
                    hs.add(down);
                    hs.add(left);
                    hs.add(right);
                    int count = 1;
                    for(int k : hs){
                        count+= hm.get(k);
                    }
                    maxCount = Math.max(count,maxCount);
                }
            }
        }

        return maxCount;
    }

    void dfs(int[][] grid, boolean[][] vis, int i , int j , int id , HashMap<Integer,Integer> hm){
        if(i< 0 || i>= grid.length || j <0 || j>= grid[0].length || grid[i][j] != 1 || vis[i][j]) return;

        vis[i][j] = true;
        grid[i][j] = id;
        hm.put(id,hm.getOrDefault(id,0)+1);
        dfs(grid,vis,i+1,j,id,hm);
        dfs(grid,vis,i-1,j,id,hm);
        dfs(grid,vis,i,j+1,id,hm);
        dfs(grid,vis,i,j-1,id,hm);
    }


}