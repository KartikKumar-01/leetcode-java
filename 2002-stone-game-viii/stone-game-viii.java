class Solution {
    int[] pref;
    int n;
    int[] dp;
    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        pref = new int[n];
        pref[0] = stones[0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i - 1] + stones[i];
        }
        return solve(1);
    }
    int solve(int i){
        if(i == n - 1) return pref[i];
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        int take = pref[i] - solve(i + 1);
        int skip = solve(i + 1);
        return dp[i] =  Math.max(take, skip);
    }
}