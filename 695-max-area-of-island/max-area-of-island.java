class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int c = 0;
                    c = dfs(i,j,grid,vis,c);
                    count = Math.max(count, c);
                }
            }
        }
        return count;
    }

    public int dfs(int i, int j, int[][] grid, boolean[][] vis, int c){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 ||grid[i][j] == 0){
            return 0;
        }
        if(vis[i][j]) return 0;

        vis[i][j] = true;
        return 1 + dfs(i+1,j,grid,vis,c)+dfs(i-1,j,grid,vis,c)+ dfs(i,j+1,grid,vis,c)+dfs(i,j-1,grid,vis,c);
    }
}