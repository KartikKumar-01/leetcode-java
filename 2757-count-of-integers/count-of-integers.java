class Solution {
    int mn;
    int mx;
    String s;
    int n;
    Long[][] dp;
    final long MOD = 1_000_000_007;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        mn = min_sum;
        mx = max_sum;
        long right = fun(num2);
        String left = subtractOne(num1);
        long leftAns = left.equals("-1") ? 0 : fun(left);    
        return (int)((right - leftAns + MOD) % MOD);    
    }
    private long fun(String num){
        s = num;
        n = s.length();
        dp = new Long[23][401];
        return helper(0, 1, 0) % MOD;
    }
    private long helper(int i, int isLimited, int sum){
        if(i == n){
            return (sum >= mn && sum <= mx) ? 1 : 0;
        }

        if(isLimited != 1){
            if(dp[i][sum] != null) return dp[i][sum];
        }

        long ans = 0;
        int limit = (isLimited == 1) ? s.charAt(i) - '0' : 9;

        for(int d = 0; d <= limit; d++){
            int newIsLimited = (isLimited == 1 && d == limit) ? 1 : 0;
            int newSum = sum + d;
                ans = (ans + helper(i + 1, newIsLimited, newSum)) % MOD;
        }
        if(isLimited != 1){
            dp[i][sum] = ans;
        }
        return ans;
    }
    private String subtractOne(String num) {

        StringBuilder sb = new StringBuilder(num);

        int i = sb.length() - 1;

        while(i >= 0 && sb.charAt(i) == '0') {
            sb.setCharAt(i, '9');
            i--;
        }

        if(i < 0) return "-1";

        sb.setCharAt(i, (char)(sb.charAt(i) - 1));

        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}