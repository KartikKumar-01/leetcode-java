class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int mn = Integer.MAX_VALUE, mni = -1;
        int mx = Integer.MIN_VALUE, mxi = -1;

        for(int i = 0; i < n; i++){
            int x = nums[i];
            if(x > mx){
                mx = x;
                mxi = i;
            }
            if(x < mn){
                mn = x;
                mni = i;
            }
        }
        int a = Math.min(mxi, mni);
        int b = Math.max(mxi, mni);
        if(a == b) return 1;

        int ans = Integer.MAX_VALUE;
        // removing from different sides
        ans = Math.min(ans, (a + 1 + n - b));

        // removing both from left
        ans = Math.min(ans, b + 1);

        // removing both from right;
        ans = Math.min(ans, n - a);

        return ans;
    }
}