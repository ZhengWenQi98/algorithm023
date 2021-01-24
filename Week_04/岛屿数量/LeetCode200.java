package cn.zwq.algorithm.middle;

/**
 * 200. 岛屿数量
 *
 * @author G20200343200113
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int islangsNums = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    islangsNums++;
                    dfs(grid, i, j);
                }
            }
        }
        return islangsNums;
    }

    /**
     * @param grid 二维网格
     * @param i    第几行
     * @param j    第几列
     */
    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
