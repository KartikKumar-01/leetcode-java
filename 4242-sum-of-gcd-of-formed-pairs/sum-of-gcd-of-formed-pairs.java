class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long mx = 0;
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            mx = Math.max(mx, nums[i]);
            a[i] = gcd(mx, nums[i]);
        }
        Arrays.sort(a);
        int i = 0, j = n - 1;
        long sum = 0;
        while(i < j){
            sum += gcd(a[i++], a[j--]);
        }
        return sum;
    }
    private long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }
}