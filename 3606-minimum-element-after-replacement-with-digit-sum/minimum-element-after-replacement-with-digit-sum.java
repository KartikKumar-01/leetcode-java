class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int x : nums){
            int s = 0;
            while(x > 0){
                s += x % 10;
                x /= 10;
            }
            ans = Math.min(ans, s);
        }
        return ans;
    }
}