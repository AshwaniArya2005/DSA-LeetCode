class Solution {
    public int orangesRotting(int[][] grid) {
        // boolean[][] vis = new boolean[grid.length][grid[0].length];
        // boolean[][] rotted = new boolean[grid.length][grid[0].length];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        int min = 0;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int nr = 0;
                int nc = 0;
                for (int[] d : dir) {
                    nr = curr[0] + d[0];
                    nc = curr[1] + d[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            fresh--;
                            q.add(new int[]{nr,nc});
                        }
                    }
                }

            }
            min++;

        }
        if (fresh > 0) {
            return -1;
        }
        return min;

    }

}