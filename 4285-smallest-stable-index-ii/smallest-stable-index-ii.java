class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        int mx = nums[0];
        for(int i = 0; i < n; i++){
            mx = Math.max(mx, nums[i]);
            int sc = mx - min[i];
            if(sc <= k) return i;
        }
        return -1;
    } 
}