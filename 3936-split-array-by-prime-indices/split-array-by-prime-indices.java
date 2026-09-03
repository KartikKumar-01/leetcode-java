class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long psum = 0;
        for(int i = 0; i < n; i++){
            if(ispm(i)) psum += (long) nums[i];
            else sum += (long) nums[i];
        }
        return Math.abs(sum - psum);
    }
    private boolean ispm(int x){
        if(x <= 1) return false;
        if(x == 2) return true;
        for(int i = 2; i * i <= x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}