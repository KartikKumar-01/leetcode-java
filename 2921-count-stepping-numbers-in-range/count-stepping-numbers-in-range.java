class Solution {
    private long MOD = (long) 1e9 + 7;
    String s;
    int n;
    Long[][] dp;
    public int countSteppingNumbers(String low, String high) {
        // dp = new Long[101][11];
        long right = fun(high);
        String left = subtractOne(low);
        long leftAns = left.equals("-1") ? 0 : fun(left);

        return (int)((right - leftAns + MOD) % MOD);
    }

    private long fun(String num){
        s = num;
        n = s.length();
        dp = new Long[n][11];
        return helper(0, 1, 1, 10);
    }
    private long helper(int i, int isLimited, int isLeadingZeroes, int last){
        if(i == n){
            return (isLeadingZeroes == 0) ? 1 : 0;
        }
        if(isLimited != 1 && isLeadingZeroes != 1){
            if(dp[i][last] != null) return dp[i][last];
        }
        long ans = 0;

        int limit = isLimited == 1 ? s.charAt(i) - '0' : 9;
        for(int d = 0; d <= limit; d++){
            int newIsLimited = (isLimited == 1 && d == limit) ? 1 : 0;
            int newIsLeadingZeroes = (isLeadingZeroes == 1 && d == 0) ? 1 : 0;
            if(newIsLeadingZeroes == 1){
                ans =( ans + helper(i + 1, newIsLimited, 1, 10)) % MOD;
            }
            else if(last == 10 || Math.abs(last - d) == 1){
                ans = (ans + helper(i + 1, newIsLimited, 0, d)) % MOD;
            }
        }
        if(isLimited != 1 && isLeadingZeroes != 1){
            dp[i][last] = ans;
        }
        return ans;
    }

    private String subtractOne(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;

        while(i >= 0 && sb.charAt(i) == '0'){
            sb.setCharAt(i, '9');
            i--;
        }
        if(i < 0) return "-1";
        sb.setCharAt(i, (char)(sb.charAt(i) - 1));

        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}