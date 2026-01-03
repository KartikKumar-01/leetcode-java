class Solution {
    static final int MOD = 1_000_000_007;

    int[][][][] dp;

    public int numOfWays(int n) {
        dp = new int[n][4][4][4];

        for (int i = 0; i < n; i++) {
            for (int c1 = 0; c1 < 4; c1++) {
                for (int c2 = 0; c2 < 4; c2++) {
                    for (int c3 = 0; c3 < 4; c3++) {
                        dp[i][c1][c2][c3] = -1;
                    }
                }
            }
        }

        return solve(0, 3, 3, 3, n);
    }

    private int solve(int row, int c1, int c2, int c3, int n) {
        if (row >= n) return 1;

        if (dp[row][c1][c2][c3] != -1)
            return dp[row][c1][c2][c3];

        long ans = 0;

        for (int i = 0; i < 3; i++) {
            if (i == c1) continue;

            for (int j = 0; j < 3; j++) {
                if (j == i || j == c2) continue;

                for (int k = 0; k < 3; k++) {
                    if (k == j || k == c3) continue;

                    ans = (ans + solve(row + 1, i, j, k, n)) % MOD;
                }
            }
        }

        return dp[row][c1][c2][c3] = (int) ans;
    }
}
