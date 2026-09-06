class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d, -1);
        return helper(s, t, 0, 0);
    }
    private int helper(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int leave = helper(s, t, i + 1, j);
        int pick = 0;
        if(s.charAt(i) == t.charAt(j)) pick = helper(s, t, i + 1, j + 1);

        return dp[i][j] = leave + pick;
    }
}