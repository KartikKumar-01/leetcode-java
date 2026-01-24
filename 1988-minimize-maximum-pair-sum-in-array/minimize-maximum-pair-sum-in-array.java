class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = n - 1;
        int ans = Integer.MIN_VALUE;
        while(i < j){
            int sum = nums[i] + nums[j];
            ans = Math.max(ans, sum);
            i++;
            j--;
        }
        return ans;
    }
}