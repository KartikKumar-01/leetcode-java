class Solution {
    class Manacher{
        int[] p;
        void build(int[] nums){
            ArrayList<Integer> t = new ArrayList<>();
            for(int num : nums){
                t.add(-1);
                t.add(num);
            }
            t.add(-1);
            runManacher(t);
        }
        void runManacher(ArrayList<Integer> t){
            int n = t.size();
            p = new int[n];
            int l = 1, r = 1; // starting largest palindrome;
            for(int i = 1; i < n; i++){
                if(i < r){
                    p[i] = Math.min(r - i, p[l + r - i]);
                }else p[i] = 0;
                while(i + p[i] < n && i - p[i] >= 0 && t.get(i + p[i]).equals(t.get(i - p[i]))){
                    p[i]++;
                }
                if(i + p[i] > r){ // update the largest palindrome yet
                    l = i - p[i];
                    r = i + p[i];
                }
            }
        }
        // find even and odd length palin from this idx as the centre
        int getLongest(int centre, boolean odd){
            int pos = 2 * centre + 1 + (odd ? 0 : 1);
            return p[pos] - 1;
        }
    }
    public long getSum(int[] nums) {
        int n = nums.length;
        long[] pref = new long[n + 1];
        for(int i = 1; i <= n; i++){
            pref[i] = pref[i - 1] + nums[i - 1];
        }
        Manacher m = new Manacher();
        m.build(nums);
        long ans = 0;
        for(int i = 0; i < n; i++){
            int odd = m.getLongest(i, true);
            int even = m.getLongest(i, false);
            long oSum = pref[i + 1 + odd / 2] - pref[i - odd / 2];
            long eSum = pref[i + 1 + even / 2] - pref[i + 1 - even / 2];
            ans = Math.max(ans ,Math.max(oSum, eSum));
        }
        return ans;
    }
}