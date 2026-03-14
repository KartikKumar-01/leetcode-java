class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] pref = new long[n + 1];

        for(int i = 1; i <= n; i++){
            pref[i] = pref[i - 1] + nums[i - 1];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;

        for(int i = 1; i < n; i++){
            int prev = i - 1;
            while(prev >= 0 && nums[prev] >= nums[i]){
                prev = left[prev];
            }
            left[i] = prev;
        }
        right[n - 1] = n;
        for(int i = n - 2; i >= 0; i--){
            int next = i + 1;
            while(next < n && nums[next] >= nums[i]){
                next = right[next];
            }
            right[i] = next;
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            int r = right[i];
            int l = left[i];
            long sum = pref[r] - pref[l + 1];
            long pd = (nums[i] * sum);
            ans = Math.max(ans, pd);
        }
        return(int) (ans % 1000000007);
    }
}