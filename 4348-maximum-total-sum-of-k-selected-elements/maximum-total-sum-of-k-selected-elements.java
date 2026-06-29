class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        for(int i = n - 1; i >= 0 && k > 0; i--){
            if(mul > 1){
                ans += 1L * nums[i] * mul;
                mul--;
            }else ans += nums[i];
            k--;
        }
        return ans;
    }
}