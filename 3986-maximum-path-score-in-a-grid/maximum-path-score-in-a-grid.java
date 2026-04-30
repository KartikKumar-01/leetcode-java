class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][] dp = new Integer[n][m][k + 1];

        int ans = helper(grid, k, 0, 0, dp);
        return (ans < 0) ? -1 : ans;
    }
    private int helper(int[][] grid, int rem, int i, int j, Integer[][][] dp){
        if(i >= grid.length || j >= grid[0].length) return Integer.MIN_VALUE;
        int cost = (grid[i][j] == 0) ? 0 : 1;
        int score = (grid[i][j] == 2) ? 2 : (grid[i][j] == 1) ? 1 : 0;
        if(cost > rem) return Integer.MIN_VALUE;

        if(i == grid.length - 1 && j == grid[0].length - 1) return score;
        if(dp[i][j][rem] != null) return dp[i][j][rem];
        int right = helper(grid, rem - cost, i, j+ 1, dp);
        int down = helper(grid, rem - cost, i + 1, j, dp);
        return dp[i][j][rem] =  score + Math.max(right, down);
    }
}