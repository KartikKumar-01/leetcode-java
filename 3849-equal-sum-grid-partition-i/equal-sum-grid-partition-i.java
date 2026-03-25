class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] pref = new long[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pref[i][j] = pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        for(int i = 0; i < n - 1; i++){
            long first = pref[i + 1][m];
            long second = pref[n][m] - first;
            // System.out.println(first + " " + second);
            if(first == second) return true;
        }
        for(int i = 0; i < m - 1; i++){
            long first = pref[n][i + 1];
            long second = pref[n][m] - first;
            // System.out.println(first + " " + second);

            if(first == second) return true;
        }
        return false;
    }
}