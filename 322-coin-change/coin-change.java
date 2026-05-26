class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = helper(coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
        // return coins;
    }
        private int helper(int[] coins, int amount, int i, int currAmount){

        if(currAmount == amount) return 0;

        if(i == coins.length || currAmount > amount || currAmount < 0)
            return Integer.MAX_VALUE;

        if(dp[i][currAmount] != -1)
            return dp[i][currAmount];

        int take = helper(coins, amount, i, currAmount + coins[i]);

        if(take != Integer.MAX_VALUE)
            take += 1;

        int skip = helper(coins, amount, i + 1, currAmount);

        return dp[i][currAmount] = Math.min(skip, take);
    }
}