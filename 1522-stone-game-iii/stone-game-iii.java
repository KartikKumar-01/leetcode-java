class Solution {
    // Integer[][] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        // dp = new Integer[n][2];
        int[] dp = new int[n + 1];
 

        for(int i = n - 1; i >= 0; i--){
            dp[i] = Integer.MIN_VALUE;
            int sum = 0;
            for(int j = 0; j < 3; j++){
                if(i + j >= n) break;
                sum += stoneValue[i + j];
                dp[i] = Math.max(dp[i], sum - dp[i + j + 1]);
            }
        }
        int ans = dp[0];
        if(ans > 0) return "Alice";
        else if(ans < 0) return "Bob";
        return "Tie";
    }
    // private int helper(int[] a, int i, int p){
    //     if(i >= a.length) return 0;
    //     if(dp[i][p] != null) return dp[i][p];
    //     int ans = 0;
    //     int sum = 0;
        
    //     if(p == 0){
    //             ans = Integer.MIN_VALUE;
    //         for(int j = 0; j < 3; j++){
    //             if(i + j >= a.length) break;
    //             sum += a[i + j];
    //             ans = Math.max(ans, sum + helper(a, i + j + 1, 1));
    //         }
    //     }else{
    //             ans = Integer.MAX_VALUE;
    //         for(int j = 0; j < 3; j++){
    //             if(i + j >= a.length) break;
    //             sum -= a[i + j];
    //             ans = Math.min(ans, sum + helper(a, i + j + 1, 0));
    //         }
    //     }
    //     return dp[i][p] = ans;
    // }
}