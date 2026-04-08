class Solution {
    final int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            int idx = l;
            while(idx <= r){
                nums[idx] = (int)((long)nums[idx] * v % MOD);
                idx += k;
            }
        }
        int xor = 0;
        for(int x : nums){
            xor ^= x;
        }
        return xor;
    }
}