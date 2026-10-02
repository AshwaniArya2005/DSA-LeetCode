class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;
        int count = 1;
        int[][] directions = {
            {1,0},{0,1},{-1,0},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}
        };
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(r == m-1 && c==n-1) return count;

                for(int[] j: directions){
                    int nr = r + j[0];
                    int nc = c + j[1];

                    if(nr >= 0 && nr <m && nc >= 0 && nc<n && grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            count++;
        }
        return -1;
    }

    
}