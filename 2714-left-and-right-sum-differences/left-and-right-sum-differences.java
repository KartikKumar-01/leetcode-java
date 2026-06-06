class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) right[i] = right[i + 1] + nums[i + 1];
        int left = 0;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = Math.abs(left - right[i]);
            left += nums[i];
        }
        return ans;
    }
}