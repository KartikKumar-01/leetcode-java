class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int n = rowCosts.length;
        int m = colCosts.length;
        int[] rp = new int[n + 1];
        int[] cp = new int[m + 1];
        for(int i = 1;  i <= n; i++){
            rp[i] = rowCosts[i - 1] + rp[ i - 1];
        }
         for(int i = 1; i <= m; i++)   cp[i] = colCosts[i - 1] + cp[ i - 1];
        int a = startPos[0];
        int b = startPos[1];
        int x = homePos[0];
        int y = homePos[1];

        int ans = 0;
        if (a < x) {
            ans += rp[x + 1] - rp[a + 1];
        } else {
            ans += rp[a] - rp[x];
        }

        if (b < y) {
            ans += cp[y + 1] - cp[b + 1];
        } else {
            ans += cp[b] - cp[y];
        }

        return ans;
    }
}