class Solution {
    public long minNumberOfSeconds(int h, int[] wt) {
        int n = wt.length;
        long low = 0;
        long high = 0;
        for(int t : wt) high = Math.max(high, t);
        high = high * ((long)h * (h + 1) / 2);

        long ans = high;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(possible(h, wt, mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    private boolean possible(int h, int[] wt, long maxTime){
        int n = wt.length;
        long reduced = 0;

        for(int t : wt){
            reduced += calc(t, maxTime);
        }
        return reduced >= h;
    }
    private long calc(int t, long mt){
        long x = 1 + ((8 * mt) / t);
        long sx = (long)Math.sqrt(x);
        return (sx - 1) / 2;
    }
}