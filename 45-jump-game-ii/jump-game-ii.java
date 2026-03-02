class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
    private int solve(int[] nums, int i){
        if(i >= nums.length - 1) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++){
            int cur = solve(nums, j);
            if(cur != Integer.MAX_VALUE) ans = Math.min(ans, cur + 1);
        }
        return dp[i] =  ans;
    }
}