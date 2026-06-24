class Solution {
    int mod = (int) 1e9 + 7;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if(n == 1) return m;
        int[][] up = new int[n + 1][m + 1];
        int[][] down = new int[n + 1][m + 1];

        for(int prev = 1; prev <= m; prev++){
            up[n][prev] = 1;
            down[n][prev] = 1;
        }
        for(int i = n - 1; i >= 0; i--){
                int[] prefup = new int[m + 1];
                int[] prefdown = new int[m + 1];
                for(int val = 1; val <= m; val++){
                    prefup[val] = (prefup[val - 1] + up[i + 1][val]) % mod;
                    prefdown[val] = (prefdown[val - 1] + down[i + 1][val]) % mod;
                }

            for(int prev = 1; prev <= m; prev++){
                // for(int next = prev + 1; next <= m; next++){
                //     up[i][prev] = (up[i][prev] + down[i + 1][next]) % mod;
                // }
                up[i][prev] = (prefdown[m] - prefdown[prev] + mod) % mod;
                // for(int next = 1; next < prev; next++){
                //     down[i][prev] = (down[i][prev] + up[i + 1][next]) % mod;
                // }
                down[i][prev] = prefup[prev - 1] % mod;
            }
        }
        int ans = 0;
        for(int start = 1; start <= m; start++){
            ans = (ans + up[1][start]) % mod;
            ans = (ans + down[1][start]) % mod;
        }
        return ans;
    }
}