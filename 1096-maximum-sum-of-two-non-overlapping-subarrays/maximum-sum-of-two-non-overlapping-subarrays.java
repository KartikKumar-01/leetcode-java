class Solution {
    int a, b;
    int[] pref;
    int[][] dp;
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        dp = new int[n + 1][3];
        for(int[] d : dp) Arrays.fill(d, -1);
        pref = new int[n + 1];
        for(int i = 1; i <= n; i++) pref[i] = pref[i - 1] + nums[i - 1];
        a = firstLen;
        b = secondLen;
        int first = helper(nums, a - 1, 0);
        
        for(int[] d : dp) Arrays.fill(d, -1);
        int temp = a;
        a = b;
        b = temp;
        int second = helper(nums, a - 1, 0);    
        return Math.max(first, second);    
    }
    private int helper(int[] nums, int i, int stage){
        if(stage == 2) return 0;
        if(i >= nums.length) return Integer.MIN_VALUE;
        if(dp[i][stage] != -1) return dp[i][stage];
        int leave = helper(nums, i + 1, stage);
        int len = (stage == 0) ? a : b;
        int nextLen = (stage == 0) ? b : 0;
        int x = helper(nums, i + nextLen, stage + 1);
        int take = Integer.MIN_VALUE;
        if(x != Integer.MIN_VALUE)
            take = pref[i + 1] - pref[i - len + 1] + x;
        return dp[i][stage] =  Math.max(leave, take);
    }
}