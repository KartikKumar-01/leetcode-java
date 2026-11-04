class Solution {
    long[] op;
    long[][] dp;
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();
    long l = 0, r = 0;
    long lsum = 0;
    long rsum = 0;
    int x, k;
    public long minOperations(int[] nums, int x, int k) {
        this.x = x;
        this.k = k;
        int n = nums.length;
        op = new long[n - x + 1];
        dp = new long[n + 1][k + 1];
        for(long[] d : dp) Arrays.fill(d, Long.MAX_VALUE / 2);
        buildMedian(nums, n, x);

        return solve(nums, 0, 0);
    }
    private long solve(int[] nums, int i, int count){
        if(count == k) return 0;
        int rem = k - count;
        int elNeeded = x * rem;
        if(i + elNeeded - 1 >= nums.length) return Long.MAX_VALUE / 2;

        if(dp[i][count] != Long.MAX_VALUE / 2) return dp[i][count];

        long res = op[i] + solve(nums, i + x, count + 1);

        res = Math.min(res, solve(nums, i + 1, count));
        return dp[i][count] = res;
    }
    private void buildMedian(int[] nums, int n, int x){
        int i = 0;
        for(int j = 0; j < n; j++){
            if(j - i + 1 > x){
                int el = nums[i];
                if(left.containsKey(el)){
                    left.put(el, left.get(el) - 1);
                    if(left.get(el) == 0) left.remove(el);
                    lsum -= el;
                    l--;
                } else {
                    right.put(el, right.get(el) - 1);
                    if(right.get(el) == 0) right.remove(el);
                    rsum -= el;
                    r--;
                }
                i++;
            }
            int el = nums[j];
            if(l < r + 1) {
                left.put(el, left.getOrDefault(el, 0) + 1);
                lsum += el;
                l++;
            } else{
                right.put(el, right.getOrDefault(el, 0) + 1);
                rsum += el;
                r++;
            }
            //balancing
            if (!left.isEmpty() && !right.isEmpty()) {
                int lmx = left.lastKey();
                int rmn = right.firstKey();

                if (lmx > rmn) {
                    left.put(lmx, left.get(lmx) - 1);
                    if (left.get(lmx) == 0) left.remove(lmx);
                    right.put(rmn, right.get(rmn) - 1);
                    if (right.get(rmn) == 0) right.remove(rmn);
                    left.put(rmn, left.getOrDefault(rmn, 0) + 1);
                    right.put(lmx, right.getOrDefault(lmx, 0) + 1);
                    lsum += rmn - lmx;
                    rsum += lmx - rmn;
                }
            }
            if (j - i + 1 == x) {
                int median = left.lastKey();
                op[i] = rsum - (long)(median * r) + (l * median) - lsum;
            }
        }
    }
}