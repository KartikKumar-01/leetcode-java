class Solution {
    int target;
    int n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % k != 0) return false;
        target = sum / k;
        Arrays.sort(nums);
        return solve(nums, 0, 0, k, new boolean[n]);
    }
    private boolean solve(int[] nums, int j, int cur, int k, boolean[] vis){
        if(k == 1) return true;
        if(cur == target) return solve(nums, 0, 0, k - 1, vis);
        for(int i = j; i < n; i++){
            if(vis[i]) continue;
            
            if(cur + nums[i] > target) continue;
            vis[i] = true;
            if(solve(nums, i + 1, cur + nums[i], k, vis)) return true;
            vis[i] = false;
        }
        return false;
    }
}