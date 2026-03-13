class Solution {
    int[][] change;
    int[][] dp;
    public boolean checkPartitioning(String s) {
        int n = s.length();
        dp = new int[n][4];

        for(int[] d : dp) Arrays.fill(d, -1);

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
        return solve(s, 3, 0);
    }
    private boolean solve(String s, int k, int i){
        if(k == 0 && i == s.length()) return true;
        if(k == 0 || i == s.length()) return false;

        if(dp[i][k] != -1) return dp[i][k] == 1;
        for(int j = i; j < s.length(); j++){
            int cost = change[i][j];
            if(cost == 0){
                if(solve(s, k - 1, j + 1)) {
                    dp[i][k] = 1;
                    return true;
                }
            }
        }
        dp[i][k] = 0;
        return false;
    }
}