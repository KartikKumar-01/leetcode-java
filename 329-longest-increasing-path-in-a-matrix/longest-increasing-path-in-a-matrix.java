class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int ans = 1;
    int n, m;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }
    private int dfs(int[][] matrix, int i, int j){
        if(dp[i][j] != 0) return dp[i][j];
        int len = 1;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && c >= 0 && r < n && c < m && matrix[r][c] > matrix[i][j]){
                len = Math.max(len, 1 + dfs(matrix, r, c));
            }
        }
        return dp[i][j] = len;
    }
}