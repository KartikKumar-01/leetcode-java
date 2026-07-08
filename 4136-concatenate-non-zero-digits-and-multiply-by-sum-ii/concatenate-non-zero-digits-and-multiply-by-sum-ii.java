class Solution {
    final long MOD = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] psum = new long[n + 1];
        long[] pcnt = new long[n + 1];
        long[] pval = new long[n + 1];
        long[] pow = new long[n + 1];
        pow[0] = 1;
        for(int i = 1; i <= n; i++){
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        for(int i = 1; i <= n; i++){
            char c = s.charAt(i - 1);
            int digit = c - '0';
            psum[i] = psum[i - 1];
            pcnt[i] = pcnt[i - 1];
            pval[i] = pval[i - 1];

            if(digit > 0){
                psum[i] += (long) digit;
                pcnt[i]++;
                pval[i] = (pval[i - 1] * 10 + digit) % MOD;
            }
        }

        return solve(queries, psum, pcnt, pval, pow);
    }
    private int[] solve(int[][] queries, long[] psum, long[] pcnt, long[] pval, long[] pow){
        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0; i < m; i++){
            int r = queries[i][1] + 1;
            int l = queries[i][0] + 1;
            long sum = psum[r] - psum[l - 1];
            long cnt = pcnt[r] - pcnt[l - 1];
            if(cnt == 0){
                res[i] = 0;
                continue;
            }
            long v = pval[r] - (pval[l - 1] * pow[(int) cnt]) % MOD;
            if(v < 0){
                v += MOD;
            }
            res[i] = (int)((sum % MOD) * (v % MOD) % MOD);
        }
        return res;
    }
}