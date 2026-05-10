class Solution {
    int[] dp;
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -2);

        int ans = solve(nums, target, 0);

        return ans < 0 ? -1 : ans;
    }

    private int solve(int[] nums, int target, int i) {

        if(i == nums.length - 1) return 0;
        if(dp[i] != -2) return dp[i];

        int ans = -1;

        for(int j = i + 1; j < nums.length; j++) {

            if(Math.abs(nums[j] - nums[i]) <= target) {

                int next = solve(nums, target, j);

                if(next != -1) {
                    ans = Math.max(ans, 1 + next);
                }
            }
        }

        return dp[i] =  ans;
    }
}