class Solution {
    int n, m;
    int[][] dir = {{1, 0}, {0, 1}};
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        dp = new Boolean[n][m][n + m + 1];
        if(grid[0][0] == ')' || grid[n - 1][m - 1] == '(') return false;
        return dfs(grid, 0, 0, 0);
    }
    public boolean dfs(char[][] grid, int i, int j, int cur){
        if(i < 0 || i >= n || j < 0 || j >= m) return false;
        cur = cur + (grid[i][j] == ')' ? -1 : 1);

        if(cur < 0) return false;

        int rem = (n - 1 - i) + (m - 1 - j);
        if(cur > rem) return false;
        
        if(i == n - 1 && j == m - 1 && cur == 0) return true;

        if(dp[i][j][cur] != null) return dp[i][j][cur];

        boolean ans = false;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(dfs(grid, r, c, cur)) {
                ans = true;
                break;
            }
        }
        return dp[i][j][cur] = ans;
    }
}