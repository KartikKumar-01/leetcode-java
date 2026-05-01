class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[0] += (i * nums[i]);
        }
        for(int i = 1; i < n; i++){
            dp[i] = sum - (n) * nums[n - i] + dp[i - 1];
            // System.out.println(dp[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int x : dp) ans = Math.max(ans, x);
        return ans;
    }
} 