class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int startc = image[sr][sc];
        dfs(sr, sc, image, color, visited, startc);
        return image;
    }

    public void dfs(int i, int j, int[][] image, int color, boolean[][] vis, int startc) {
        if (i >= image.length || i < 0 || j >= image[0].length || j < 0) {
            return;
        }
        if (image[i][j] != startc) {
            return;
        }
        if (vis[i][j])
            return;

        vis[i][j] = true;
        image[i][j] = color;
        dfs(i + 1, j, image, color, vis, startc);
        dfs(i - 1, j, image, color, vis, startc);
        dfs(i, j + 1, image, color, vis, startc);
        dfs(i, j - 1, image, color, vis, startc);

    }
}