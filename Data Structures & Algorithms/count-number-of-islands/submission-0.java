
class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {  // Note: '1' instead of 1
                    islandCount++;
                    bfs(i, j, grid);
                }
            }
        }
        return islandCount;
    }

    public void bfs(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';  // Mark as visited

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // Up, Down, Left, Right

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];

            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';  // Mark as visited
                }
            }
        }
    }
}
