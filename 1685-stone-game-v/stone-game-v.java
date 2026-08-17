class Solution {
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n + 1][n + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int[] pref = new int[n + 1];
        for(int i = 1; i <= n; i++ ) pref[i] = pref[i - 1] + stoneValue[i - 1];
        return helper(stoneValue, 0, n - 1, pref);
    }
    private int helper(int[] s, int i, int j, int[] pref){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        for(int p = i; p < j; p++){
            int left = pref[p + 1] - pref[i];
            int right = pref[j + 1] - pref[p + 1];
            if(left > right){
                ans = Math.max(ans, right + helper(s, p + 1, j, pref));
            }else if(right > left){
                ans = Math.max(ans, left + helper(s, i, p, pref));
            }else {
                ans = Math.max(ans, left + Math.max(helper(s, p + 1, j, pref), helper(s, i, p, pref)));
            }
        }
        return dp[i][j] = ans;
    }
}