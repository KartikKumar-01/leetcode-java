class Solution {
    int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int size = n * m;
        int[] a = new int[size];

        int idx = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[idx++] = grid[i][j] % MOD; 

        int[] pref = new int[size];
        int[] suff = new int[size];

        pref[0] = 1;
        for (int i = 1; i < size; i++)
            pref[i] = (int)((1L * pref[i - 1] * a[i - 1]) % MOD);

        suff[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--)
            suff[i] = (int)((1L * suff[i + 1] * a[i + 1]) % MOD);

        int[][] ans = new int[n][m];
        idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int)((1L * pref[idx] * suff[idx]) % MOD);
                idx++;
            }
        }

        return ans;
    }
}