class Solution {
    int n;
    int m;
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(nums1, nums2, 0, 0);
    }
    private int solve(int[] a, int[] b, int i, int j){
        if(i >= n || j >= m){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j] != -1) return dp[i][j];
        int ans = a[i] * b[j] + Math.max(0, solve(a, b, i + 1, j + 1));

        ans = Math.max(ans, solve(a, b, i + 1, j));
        ans = Math.max(ans, solve(a, b, i, j + 1));
        return dp[i][j] = ans;
    }
}