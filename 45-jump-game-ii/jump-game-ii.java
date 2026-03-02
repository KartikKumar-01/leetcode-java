class Solution {
    int[] dp;
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int count = 0;
        int currentEnd = 0;
        for(int i = 0; i < n - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currentEnd){
                count++;
                currentEnd = farthest;
            }
        }
        return count;
    }
}