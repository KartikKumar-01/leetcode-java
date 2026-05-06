class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        Arrays.sort(nums);
        int i = 0;
        long sum = 0;
        for(int j = 0; j < n; j++){
            sum += (long)nums[j];
            while(sum + k < (long)nums[j] * (j - i + 1)){
                sum -= nums[i];
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}