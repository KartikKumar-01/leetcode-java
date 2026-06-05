class Solution {
    String s;
    int n;
    int div;
    Integer[][][] dp;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        div = k;
        return fun(high) - fun(low - 1);
    }
    private int fun(int num){
        s = String.valueOf(num);
        n = s.length();
        dp = new Integer[n][div][25];
        return solve(0, 1, 1, 0, 15);
    }
    private int solve(int i, int limited, int leadingZeroes, int rem, int balance){
        if(i == n){
            return (leadingZeroes == 0 && rem == 0 && balance == 15) ? 1 : 0;
        }

        if(limited != 1 && leadingZeroes != 1){
            if(dp[i][rem][balance] != null) return dp[i][rem][balance];
        }

        int ans = 0;
        int limit = (limited == 1) ? s.charAt(i) - '0' : 9;
        for(int d = 0; d <= limit; d++){
            int newLeadingZeroes = (leadingZeroes == 1 && d == 0) ? 1 : 0;
            int newLimited = (limited == 1 && d == limit) ? 1 : 0;
            int newRem = rem;
            int newBalance = balance;

            if(newLeadingZeroes == 0){
                newRem = (rem * 10 + d) % div;
                if(d % 2 == 0) newBalance++;
                else newBalance--;
            }
            if(newBalance < 4 || newBalance > 24) continue;
            ans += solve(i + 1, newLimited, newLeadingZeroes, newRem, newBalance);
        }
         if(limited != 1 && leadingZeroes != 1){
            dp[i][rem][balance] = ans;
        }
        return ans;
    }
}