class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int mini = -1;
        int maxi = -1;
        int badi = -1;
        long ans = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] > maxK || nums[j] < minK) badi = j;
            if(nums[j] == minK) mini = j;
            if(nums[j] == maxK) maxi = j;

            int start = Math.min(maxi, mini);
            if(start > badi){
                ans += (long)(start - badi);
            }
        }
        return ans;
    }
}