class Solution {
    private static final int INF = 1_000_000_000;
    int[][] dp;
    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        dp = new int[n + 1][sum + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = helper(nums, sum, 0);
        return ans == INF ? -1 : ans;
    }
    private int helper(int[] nums, int sum, int i) {
        if (sum == 0) return 0;
        if(i == nums.length) return INF;
        if(dp[i][sum] != -1) return dp[i][sum];
        int ans = helper(nums, sum, i + 1);

        int op = 0;
        int x = nums[i];
        while(x <= sum){
            ans = Math.min(ans, op + helper(nums, sum - x, i + 1));
            op++;
            x *= 2;
        }

        x = nums[i];
        op = 0;
        while(x > 0){
            if(x <= sum) ans = Math.min(ans, op + helper(nums, sum - x, i + 1));
            x /= 2;
            op++;
        }
        return dp[i][sum] =  ans;
    }
}