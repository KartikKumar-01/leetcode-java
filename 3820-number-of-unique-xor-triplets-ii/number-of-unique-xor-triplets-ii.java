class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] ans = new boolean[2048];

        for (int x : nums) {
            for (int v = 0; v < 2048; v++) {
                if (pair[v]) {
                    ans[x ^ v] = true;
                }
            }
        }

        int res = 0;
        for (boolean b : ans) {
            if (b) res++;
        }
        return res;
    }
}