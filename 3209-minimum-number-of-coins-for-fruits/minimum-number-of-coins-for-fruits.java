class Solution {
    int[][] dp;
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        dp  = new int[n][n + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(prices, 0, 0);
    }
    private int solve(int[] prices, int i, int free){
        if(i >= prices.length) return 0;
        if(dp[i][free] != -1) return dp[i][free];
        int take = solve(prices, i + 1, i + 1) + prices[i];
        int noTake = Integer.MAX_VALUE;
        if(free > 0){
            noTake = solve(prices, i + 1, free - 1);
        }
        return dp[i][free] = Math.min(take, noTake);
    }
}