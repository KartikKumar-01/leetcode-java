class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;
        int[] cnt = new int[n + 1];
        for(int x : arr){
            cnt[Math.min(x, n)]++;
        }

        int ans = 1;
        for(int i = 2; i <= n; i++){
            ans = Math.min(ans + cnt[i], i);
        }
        return ans;

        // int[] a = new int[(int) 1e5 + 1];

        // for(int x : arr){
        //     a[x]++;
        // }

        // int ans = 0;
        // for(int i = 0; i < a.length; i++){
        //     if(a[i] == 0) continue;

        //     int diff = i - ans;
        //     ans += Math.min(diff, a[i]);
        // }
        // return ans;
    }
}