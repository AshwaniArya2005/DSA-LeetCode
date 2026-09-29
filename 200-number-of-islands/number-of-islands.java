class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i <grid.length;i++){
            for(int j = 0 ; j <grid[0].length;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i , int j , boolean[][] vis){
        if(vis[i][j]) return;
        if(grid[i][j] == '0') return;

        vis[i][j] = true;
        if(i+1 < grid.length) dfs(grid,i+1,j,vis);
        if(j+1 < grid[0].length) dfs(grid,i,j+1,vis);
        if(i-1 >= 0) dfs(grid,i-1,j,vis);
        if(j-1 >= 0) dfs(grid,i,j-1,vis);
    }
}