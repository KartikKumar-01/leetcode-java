class Solution {
    int MOD = (int) 1e9 + 7;
    int[] dp = new int[2001];
    int[] prev;
    public int distinctSubseqII(String s) {
        int n = s.length();
        prev = new int[n + 1];
        int[] lastSeen = new int[26];
        Arrays.fill(dp, -1);

        for(int i = 1; i <= n; i++){
            int id = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[id];
            lastSeen[id] = i;
        }

        return (helper(n) - 1 + MOD) % MOD;
    }
    private int helper(int n){
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        int total = 2 * helper(n - 1) % MOD;
        if(prev[n] != 0){
            int dup = helper(prev[n] - 1) % MOD;
            total = (total - dup + MOD) % MOD;
        }
        return dp[n] = total % MOD;
    }
}