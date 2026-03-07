class Solution {
    int[][] dp;
    public int maxScore(int n, int k, int[][] s, int[][] t) {

        int ans = 0;
        dp = new int[n + 1][k + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        for(int start = 0; start < n; start++){
            ans = Math.max(ans, solve(s, t, start, 0, k));
        }
        return ans;
    }
    private int solve(int[][]s, int[][] t, int city, int day, int k){
        if(k == day) return 0;
        if(dp[city][day] != -1) return dp[city][day];
        int ans = s[day][city] + solve(s, t, city, day + 1, k);
        for(int next = 0; next < t.length; next++){
            // if(next != city){
                ans = Math.max(ans, t[city][next] + solve(s, t, next, day + 1, k));
            // }
        }
        return dp[city][day] =  ans;
    }
}