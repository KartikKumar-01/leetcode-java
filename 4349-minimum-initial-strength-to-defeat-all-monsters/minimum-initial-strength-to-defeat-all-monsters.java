class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] bonus = new long[n];
        for(int[] q : boosts){
            int l = q[0], r = q[1], b = q[2];
            bonus[l] += b;
            if(r + 1 < n) bonus[r + 1] -= b;
        }
        for(int i = 1; i < n; i++) bonus[i] += bonus[i - 1];
        long low = 0, high = 0;
        for(int x : monsters) high += x;
        long ans = high;

        while(low <= high){
            long mid = low + (high - low ) / 2;
            if(possible(monsters, mid, bonus)){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    private boolean possible(int[] a, long s, long[] b){
        long cur = s;
        for(int i = 0; i < a.length; i++){
            if(cur + b[i] < a[i])return false;
            cur -= a[i];
            if(cur < 0) cur = 0;
        }
        return true;
    }
}