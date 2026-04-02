class Solution {
    int n, m;
    int[][][] dp;   
    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;
        dp = new int[n + 1][m + 1][3];
        for(int[][] d: dp)
            for(int[] a : d) Arrays.fill(a, Integer.MIN_VALUE);
        return solve(coins, 0, 0, 2);
    }
    private int solve(int[][] coins, int i, int j, int k){
        if(i >= n || i < 0 || j >= m || j < 0) return Integer.MIN_VALUE;
        if(i == n - 1 && j == m - 1){
            if(coins[i][j] < 0) {
                if(k > 0) return 0;
                return coins[i][j];
            }
            return coins[i][j];
        }
        if(dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];
        int ans;
        if(coins[i][j] >= 0){
            ans = coins[i][j] + Math.max(solve(coins, i, j + 1, k), solve(coins, i + 1, j, k));
        }else{
            int take = coins[i][j] + Math.max(solve(coins, i, j + 1, k), solve(coins, i + 1, j, k));
            int skip = Integer.MIN_VALUE;
            if(k > 0) skip = Math.max(solve(coins, i, j + 1, k - 1), solve(coins, i + 1, j, k - 1));

            ans = Math.max(take, skip);
        }
        return dp[i][j][k] = ans;
    }
}