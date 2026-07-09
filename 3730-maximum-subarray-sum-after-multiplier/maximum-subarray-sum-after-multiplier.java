class Solution {
    public long maxSubarraySum(int[] nums, int k){
        long ans = Math.max(solve(nums, k, 0), solve(nums, k, 1));
        return ans;
    }
    public long solve(int[] nums, int k, int flag) {
        int n = nums.length;
        long[] p0 = new long[n];
        long[] p1 = new long[n];
        long[] p2 = new long[n];

        p0[0] = nums[0];
        p1[0] = op(nums[0] * 1L, k, flag);
        p2[0] = Long.MIN_VALUE / 2;

        
        long ans = Math.max(p0[0], p1[0]);
        for(int i = 1; i < n; i++){
            long val = op(nums[i] * 1L, k, flag);
            p0[i] = Math.max(p0[i - 1] + nums[i], nums[i]);
            p1[i] = Math.max(val, Math.max(val + p0[i - 1], p1[i - 1] + val));
            p2[i] = Math.max(p1[i - 1] + nums[i], p2[i - 1] + nums[i]);
            long cur = Math.max(p0[i], Math.max(p1[i], p2[i]));
            ans = Math.max(ans, cur);
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