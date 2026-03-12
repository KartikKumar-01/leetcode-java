class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y >= x) return y - x;
        int ans = Math.abs(x - y);
        ans = Math.min(ans, 1 + x % 5 + minimumOperationsToMakeEqual(x / 5, y));
        ans = Math.min(ans, 1 + (5 - x % 5) + minimumOperationsToMakeEqual(x / 5 + 1, y));
        ans = Math.min(ans, 1 + x % 11 + minimumOperationsToMakeEqual(x / 11, y));
        ans = Math.min(ans, 1 + (11 - x % 11) + minimumOperationsToMakeEqual(x / 11 + 1, y));
        return ans;
    }
}