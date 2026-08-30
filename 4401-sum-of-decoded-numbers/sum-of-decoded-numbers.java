class Solution {
    int mod = 1_000_000_000 + 7;
    public int sumDecoded(long[] nums) {
        int n = nums.length;
        long ans = 0;

        for(long a : nums){
            int w = (int)(a % 10);
            long d = a / 10;
            String num = String.valueOf(d);
            long x = Long.parseLong(num.substring(0, w));
            long y = Long.parseLong(num.substring(w));
            long dd = exp(x, y);
            ans = (ans + dd) % mod;
        }
        return (int)ans;
    }
    long exp(long a, long b){
        long ans = 1;
        a %= mod;

        while(b > 0){
            if((b & 1) == 1){
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return ans;
    }
}