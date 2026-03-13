class Solution {
    int[][] dp;
    int[][] change;
    public int palindromePartition(String s, int k) {
        int n = s.length();
        dp = new int[n + 1][k + 1];
        change = new int[n][n];
        for(int len = 2; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    change[i][j] = (len == 2) ? 0 : change[i + 1][j - 1];
                }else{
                    change[i][j] = (len == 2) ? 1 : change[i + 1][j - 1] + 1;
                }
            }
        }
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(s, k, 0);
    }
    private int solve(String s, int k, int i){
        if(k == 0 && i == s.length()) return 0;
        if(i == s.length() || k == 0) return Integer.MAX_VALUE;
        if(dp[i][k] != -1) return dp[i][k];
        int ans = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++){
            int cost = change[i][j];
            int next = solve(s, k - 1, j + 1);
            if(next != Integer.MAX_VALUE)
                ans = Math.min(ans, cost + next);
        }
        return dp[i][k] = ans;
    }
}