class Solution {
    int ans = Integer.MIN_VALUE;
    int n;
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        this.n = arr.length;
        this.dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, helper(arr, i, d));
        }
        return ans;
    }
    private int helper(int[] arr, int i, int d){
        if(dp[i] != -1) return dp[i];
        int best = 1;
        for(int j = i + 1; j <= Math.min(n - 1, i + d); j++){
            if(arr[j] >= arr[i]){
                break;
            }
            best = Math.max(best, 1 + helper(arr, j, d));
        }
        for(int j = i - 1; j >= Math.max(0, i - d); j--){
            if(arr[j] >= arr[i]) break;
            best = Math.max(best, 1 + helper(arr, j, d));
        }
        return dp[i] = best;
    }
}