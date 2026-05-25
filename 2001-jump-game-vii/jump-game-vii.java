class Solution {
    // int[] dp;
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachable = 0;

        for(int i = 1; i < n; i++) {

            if(i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            if(i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            if(s.charAt(i) == '0' && reachable > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
    // private boolean helper(String s, int i, int mn, int mx, int[] pref){
    //     if(i >= s.length()) return false;
    //     if(i == s.length() - 1) return true;

    //     int l = Math.min(i + mn, s.length());
    //     int r = Math.min(i + mx, s.length());
    //     if(l >= s.length()) return false;
    //     int cnt = pref[r + 1] - pref[l];
    //     // System.out.println(l + " " + r);   
    //     if(cnt == 0) return false;
    //     for(int j = l; j <= r; j++){
    //         if(s.charAt(j) == '0' && helper(s, j, mn, mx, pref)) return true;
    //     } 
    //     return false;
    // }
}