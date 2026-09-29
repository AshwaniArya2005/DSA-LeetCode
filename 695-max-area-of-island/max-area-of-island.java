class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int maxCount = 0;
        for(int i =0 ; i <grid.length;i++){
            for(int j = 0 ; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    if(!vis[i][j]){
                        int count = dfs(grid,vis,i,j);
                        maxCount = Math.max(count, maxCount);
                    }   
                }
            }
        }
        return maxCount;
    }

    int dfs(int[][] grid, boolean[][] vis, int i, int j){
        if(grid[i][j] != 1) return 0;
        if(vis[i][j]) return 0;
        int count = 0;
        if(grid[i][j] == 1) count++;
        vis[i][j] = true;

        if(i+1 <grid.length) count+= dfs(grid,vis,i+1,j);
        if(j+1 <grid[0].length) count += dfs(grid,vis,i,j+1);
        if(i-1 >=0) count+=  dfs(grid,vis,i-1,j);
        if(j-1 >=0)count += dfs(grid,vis,i,j-1);
        return count;


    }
}