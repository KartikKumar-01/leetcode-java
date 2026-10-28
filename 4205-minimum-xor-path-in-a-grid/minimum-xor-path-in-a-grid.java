class Solution {
    int[][][] dp;
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][1024];
        for(int[][] d : dp){
            for(int[] d1 : d){
                Arrays.fill(d1, -1);
            }
        }
        return dfs(grid, 0, 0, 0);
    }
    private int dfs(int[][] grid, int i, int j, int xor){
        if(i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        xor ^= grid[i][j];
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return xor;
        }
        if(dp[i][j][xor] != -1) return dp[i][j][xor];
        int right = dfs(grid, i, j + 1, xor);
        int left = dfs(grid, i + 1, j, xor);
        return dp[i][j][xor] = Math.min(right, left);
    }
}