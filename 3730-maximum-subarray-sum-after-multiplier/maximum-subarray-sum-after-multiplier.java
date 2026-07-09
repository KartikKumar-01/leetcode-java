class Solution {
    public long maxSubarraySum(int[] nums, int k){
        long ans = Math.max(solve(nums, k, 0), solve(nums, k, 1));
        return ans;
    }
    public long solve(int[] nums, int k, int flag) {
        int n = nums.length;
        // long[] p0 = new long[n];
        // long[] p1 = new long[n];
        // long[] p2 = new long[n];

        // p0[0] = nums[0];
        // p1[0] = op(nums[0] * 1L, k, flag);
        // p2[0] = Long.MIN_VALUE / 2;
        long p0 = nums[0];
        long p1 = op(nums[0] * 1L, k, flag);
        long p2 = Long.MIN_VALUE / 2;

        
        long ans = Math.max(p0, p1);
        for(int i = 1; i < n; i++){
            long val = op(nums[i] * 1L, k, flag);
            long cp0 = Math.max(p0 + nums[i], nums[i]);
            long cp1 = Math.max(val, Math.max(val + p0, p1 + val));
            long cp2 = Math.max(p1 + nums[i], p2 + nums[i]);
            long cur = Math.max(cp0, Math.max(cp1, cp2));
            ans = Math.max(ans, cur);
            p0 = cp0;
            p1 = cp1;
            p2 = cp2;
        }
        // for(int i = 0; i < n; i++){
        //     ans = Math.max(ans, Math.max(p0[i], Math.max(p1[i], p2[i])));
        // }

        return ans;
    }
    private long op(long x, int k, int flag){
        if(flag == 0) return x * k * 1L;
        return div(x, k);
    }
    private long div(long x, long k){
        if(x >= 0) return x / k;
        return -((-x) / k);
    }
}