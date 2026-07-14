class Solution {
    int[][][] dp;
    int MOD = (int) 1e9 + 7;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        dp = new int[n][201][201];
        for(int[][] d : dp) for(int[] a : d) Arrays.fill(a, -1);
        return (solve(nums, 0, 0, 0) - 1 + MOD) % MOD;
    }
    private int solve(int[] nums, int i, int gp, int gnp){
        if(i == nums.length){
            return gp == gnp ? 1 : 0;
        }
        if(dp[i][gp][gnp] != -1) return dp[i][gp][gnp];

        int ans = 0;
        int pick = solve(nums, i + 1, gcd(gp, nums[i]), gnp) % MOD;
        int nopick = solve(nums, i + 1, gp, gcd(gnp, nums[i])) % MOD;
        int leave = solve(nums, i + 1, gp, gnp) % MOD;

        return dp[i][gp][gnp] = ((pick + nopick) % MOD + leave) % MOD;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}