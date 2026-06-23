class Solution {
    final int mod = (int) 1e9 + 7;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if(n == 1) return m;
        int[][] up = new int[n + 1][m];
        int[][] down = new int[n + 1][m];
        for(int i = 0; i < m; i++){
            up[2][i] = i; // two elements with x < y
            down[2][i] = m - i - 1; // two element with x > y
        }

        for(int i = 3; i <= n; i++){
            long[] prefup = new long[m + 1];
            long[] prefdown = new long[m + 1];
            for(int v = 0; v < m; v++){
                prefup[v + 1] = (prefup[v] + up[i - 1][v]) % mod;
                prefdown[v + 1] = (prefdown[v] + down[i - 1][v]) % mod;
            }

            for(int v = 0; v < m; v++){
                up[i][v] = (int)prefdown[v];
                down[i][v] = (int) (prefup[m] - prefup[v + 1] + mod) % mod;
            }
        }
        long ans = 0;
        for (int v = 0; v < m; v++) {
            ans = (ans + up[n][v]) % mod;
            ans = (ans + down[n][v]) % mod;
        }

        return (int) ans;
    }
}