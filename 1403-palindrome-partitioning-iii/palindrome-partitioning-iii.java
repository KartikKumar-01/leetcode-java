class Solution {
    int[][] dp;
    public int palindromePartition(String s, int k) {
        int n = s.length();
        dp = new int[n + 1][k + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(s, k, 0);
    }
    private int solve(String s, int k, int i){
        if(k == 0 && i == s.length()) return 0;
        if(i == s.length() || k == 0) return Integer.MAX_VALUE;
        if(dp[i][k] != -1) return dp[i][k];
        int ans = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++){
            String sbt = s.substring(i, j + 1);
            int cost = change(sbt);
            int next = solve(s, k - 1, j + 1);
            if(next != Integer.MAX_VALUE)
                ans = Math.min(ans, cost + next);
        }
        return dp[i][k] = ans;
    }
    private int change(String s){
        int n = s.length();
        int cnt = 0;
        int l = 0, r = n - 1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) cnt++;
        }
        return cnt;
    }
}