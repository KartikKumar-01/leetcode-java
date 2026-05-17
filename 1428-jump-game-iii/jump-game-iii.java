class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        return helper(arr, start, new boolean[n]);
    }
    private boolean helper(int[] a, int i, boolean[] vis){
        if(i < 0 || i >= a.length || vis[i]) return false;
        if(a[i] == 0) return true;
        vis[i] = true;
        boolean f = helper(a, i - a[i], vis);
        boolean s = helper(a, i + a[i], vis);
        // vis[i] = false;
        return f || s;
    }
}