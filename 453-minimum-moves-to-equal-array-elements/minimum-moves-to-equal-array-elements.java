class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int x : nums){
            sum += x;
            min = Math.min(x, min);
        }
        return sum - n * min;
    }
}