class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        // System.out.println(n);
        long[] sp = new long[n];
        long LIMIT = (long)1e18;
        sp[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            if(sp[i + 1] > LIMIT / nums[i + 1]) {
                sp[i] = LIMIT; 
            } else {
                sp[i] = sp[i + 1] * nums[i + 1];
            }
        }
        long sum = 0;
        long pr = 1;
        for(int i = 0; i < n; i++){
            if(sum == sp[i]) return i;
            sum += (long)nums[i];
        }
        return -1;
    }
}