class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] count = new long[2 * n + 2];
        long[] cumm = new long[2 * n + 2];
        int ps = n + 1;
        count[ps] = cumm[ps] = 1;
        long res = 0;
        for(int a : nums){
            ps += (a == target ? 1 : -1);
            count[ps]++; // inc count of cur pref sum
            cumm[ps] = count[ps] + cumm[ps - 1]; // count of pref sums less than equal to cur ps
            res += cumm[ps - 1];
        }
        return res;
    }
}