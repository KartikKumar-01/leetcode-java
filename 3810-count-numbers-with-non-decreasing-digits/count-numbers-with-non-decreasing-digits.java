class Solution {
    int b;
    Integer[][] dp;
    int MOD = (int) 1e9 + 7;
    public int countNumbers(String l, String r, int b) {
        this.b = b;
        String lt = convert(minus1(l));
        String rt = convert(r);
        int left = fun(lt);
        int right = fun(rt);
        return ((right - left) + MOD) % MOD;
    }
    private int fun(String s){
        dp = new Integer[s.length() + 1][10];
        return solve(s, 0, 1, 1, 0);
    }

    private int solve(String s, int i, int limited, int leadingZeroes, int prev){
        if(i == s.length()){
            return (leadingZeroes != 1) ? 1 : 0;
        }
        if(limited != 1 && leadingZeroes != 1){
            if(dp[i][prev] != null) return dp[i][prev];
        }
        int limit = (limited == 1) ? s.charAt(i) - '0' : (b - 1);
        int ans = 0;
        for(int d = 0; d <= limit; d++){
            if(leadingZeroes == 0 && d < prev) continue;
            int newLimited = (limited == 1 && d == limit) ? 1 : 0;
            int newLeadingZereoes = (leadingZeroes == 1 && d == 0) ? 1 : 0;
            if(newLeadingZereoes == 1){
                ans = (ans + solve(s, i + 1, newLimited, newLeadingZereoes, prev)) % MOD;
            }else ans = (ans + solve(s, i + 1, newLimited, newLeadingZereoes, d)) % MOD;
        }
        if(limited != 1 && leadingZeroes != 1){
            dp[i][prev] = ans % MOD;
        }
        return ans % MOD;
    }
    private String convert(String s){
        StringBuilder sb = new StringBuilder();
        String cur = s;
        while(!cur.equals("0")){
            StringBuilder qt = new StringBuilder();
            int rem = 0;
            for(int i = 0; i < cur.length(); i++){
                int num = rem * 10 + (cur.charAt(i) - '0');
                int q = num / b;
                rem = num % b;
                if(!(qt.length() == 0 && q == 0)){
                    qt.append(q);
                }
            }
                sb.append(rem);
                if(qt.length() == 0){
                    cur = "0";
                }else cur = qt.toString();
        }
        return sb.reverse().toString();
    }
    private String minus1(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;
        while(i >= 0 && sb.charAt(i) == '0'){
            sb.setCharAt(i, '9');
            i--;
        }
        if(i >= 0){
            sb.setCharAt(i, (char)(sb.charAt(i) - 1));
        }
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}