class Solution {
    int n;
    int[] arr;
    public int distributeCookies(int[] nums, int k) {
        n = nums.length;
        arr = new int[k];
        Arrays.sort(arr);
        return solve(nums, 0, new boolean[n], k);
    }
    private int solve(int[] nums, int i, boolean[] vis, int k){
        if(i == n){
            int res = 0;
            for(int x : arr){
                res = Math.max(res, x);
            }
            return res;
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++){
            if(vis[i]) continue;
            arr[j] += nums[i];
            vis[i] = true;
            ans = Math.min(ans, solve(nums, i + 1, vis, k));
            arr[j] -= nums[i];
            vis[i] = false;
        }
        return ans;
    }
}