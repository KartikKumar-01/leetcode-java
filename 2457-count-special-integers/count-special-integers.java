class Solution {
    String s;
    int len;
    int[][] dp;
    public int countSpecialNumbers(int n) {
        s = String.valueOf(n);
        len = s.length();
        dp = new int[10][1 << 10];
        for(int[]d : dp) Arrays.fill(d, -1);
        return solve(0, 1, 1, 0) - 1;
    }
    private int solve(int i, int limited, int leadingZeroes, int mask){
        if(i == len) return 1;
        if(limited != 1 && leadingZeroes != 1){
            if(dp[i][mask] != -1) return dp[i][mask];
        }
        int ans = 0;
        int limit = (limited == 1) ? s.charAt(i) - '0' : 9;
        for(int d = 0; d <= limit; d++){
            int newLimited = limited == 1 && d == limit ? 1 : 0;
            int newLeadingZeroes = leadingZeroes == 1 && d == 0 ? 1 : 0;
            if(newLeadingZeroes == 1){
                ans += solve(i + 1, newLimited, newLeadingZeroes, mask);
            }
            else{
                if((mask & (1 << d)) != 0){
                    continue;
                }
                ans += solve(i + 1, newLimited, newLeadingZeroes, mask | (1 << d));
            }
        }
        if(limited != 1 && leadingZeroes != 1){
            dp[i][mask] = ans;
        }
        return ans;
    }
}