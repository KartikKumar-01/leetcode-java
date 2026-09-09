class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long s = 1000;
        int x = 1;
        while(s <= n){
            long e = s * 1000 - 1;
            long u = Math.min(e, n);
            ans += (u - s + 1) * x;
            s *= 1000;
            x++;
        }
        return ans;
    }
}