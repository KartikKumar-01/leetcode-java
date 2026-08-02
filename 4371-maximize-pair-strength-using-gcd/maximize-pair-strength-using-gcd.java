class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long gcd = gcd((long)nums[i], (long)nums[j]);
                long val = (long) nums[i] * nums[j];
                long sq = gcd * gcd;
                ans = Math.max(ans, val / sq);
            }
        }
        return ans;
    }
    private long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }
}