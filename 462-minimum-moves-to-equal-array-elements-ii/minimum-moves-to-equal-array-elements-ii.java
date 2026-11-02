class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = n / 2;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i == mid) continue;
            ans += (Math.abs(nums[i] - nums[mid]));
        }
        return ans;
    }
}