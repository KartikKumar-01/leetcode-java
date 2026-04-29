class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }
    private int solve(String s, int i){
        if(i >= s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int ans = solve(s, i + 1);
        if(i + 1 < s.length()){
            int x = Integer.parseInt(s.substring(i, i + 2));
            if(x <= 26){
                ans += solve(s, i + 2);
            }
        }
        return dp[i] = ans;
    }
}