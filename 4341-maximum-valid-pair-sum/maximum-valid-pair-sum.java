class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        int ans = 0;
        max[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(i - k >= 0){
                ans = Math.max(ans, nums[i] + max[i - k]);
            }
            max[i] = Math.max(max[i - 1], nums[i]);
        }
        return ans;
    }
}