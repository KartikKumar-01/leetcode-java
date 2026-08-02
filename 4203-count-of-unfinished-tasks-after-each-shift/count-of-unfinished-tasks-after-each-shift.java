class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int[] ans = new int[shifts.length];

        long[] pref = new long[n];
        pref[0] = (long)tasks[0];
        for(int i = 1; i < n; i++) pref[i] = pref[i - 1] + tasks[i];
        long s = 0;
        for(int i = 0; i < shifts.length; i++){
            s += shifts[i];
            if(pref[n - 1] <= s) {
                ans[i] = 0;
                s = 0;
            }else{
                ans[i] = n - ub(pref, s);
            }
        }
        return ans;
    }
    public int ub(long[] arr, long target) {
    int low = 0, high = arr.length - 1;
    int ans = arr.length;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] > target) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return ans;
}
}