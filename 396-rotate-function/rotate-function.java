class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int f = 0;
        for(int i = 0; i < n; i++){
            f += (i * nums[i]);
            sum += nums[i];
        }
        int ans = f;
        for(int i = 1; i < n; i++){
            int t = sum - (n) * nums[n - i] + f;
            f = t;
            ans = Math.max(f, ans);
        }
        return ans;
    }
} 