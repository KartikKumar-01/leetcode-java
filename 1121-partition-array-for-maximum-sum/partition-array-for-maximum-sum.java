class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(arr, 0, k);
    }
    private int helper(int[] a, int i, int k){
        if(i >= a.length)return 0;
        if(dp[i] != -1) return dp[i];
        int ans = 0;
        int max = 0;
        int n = a.length;
        for(int j = i; j < Math.min(n, i + k); j++){
            max = Math.max(max, a[j]);
            int val = (max * (j - i + 1));
            ans = Math.max(ans, val + helper(a, j + 1, k));
        }
        return dp[i] =  ans;
    }
}