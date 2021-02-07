package cn.zwq.algorithm.middle;

/**
 * 64. 最小路径和
 *
 * @author G20200343200113
 */
public class LeetCode64 {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        //求第一列每个方格路径和，[0][0],[1][0],[2][0],[3][0],...
        //当前方格 + 上一行方格
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        //求第一行每个方格路径和，[0][0],[0][1],[0][2],[0][3],...
        //当前方格 + 左边方格
        for (int i = 1; i < columns; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        //填充其余方格路径和，求最小值
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
