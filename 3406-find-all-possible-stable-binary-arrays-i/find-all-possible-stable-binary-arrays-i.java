class Solution {
    Integer[][][] dp ;
    final int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2];
        return (solve(zero, one, 1, limit) + solve(zero, one, 0, limit)) % MOD;
    }
    private int solve(int zeroLeft, int oneLeft, int last, int limit){
        if(zeroLeft == 0 && oneLeft == 0) return 1;
        int res = 0;

        if(dp[zeroLeft][oneLeft][last] != null) return dp[zeroLeft][oneLeft][last];

        if(last == 1){
            for(int i = 1; i <= Math.min(zeroLeft, limit); i++){
                res = (res + solve(zeroLeft - i, oneLeft, 0, limit)) % MOD;
            }
        }
        else{
            for(int i = 1; i <= Math.min(oneLeft, limit); i++){
                res = (res + solve(zeroLeft, oneLeft - i, 1, limit)) % MOD;
            }
        }
        return dp[zeroLeft][oneLeft][last] = res % MOD;
    }
}