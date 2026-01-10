class Solution {
    int[][] dp;
    int n, m;

    public int minimumDeleteSum(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s1, s2, 0, 0);
    }

    private int helper(String s1, String s2, int i, int j) {
        if (i == n) {
            int sum = 0;
            for (int k = j; k < m; k++) sum += s2.charAt(k);
            return sum;
        }

        if (j == m) {
            int sum = 0;
            for (int k = i; k < n; k++) sum += s1.charAt(k);
            return sum;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = helper(s1, s2, i + 1, j + 1);
        }

        int deleteS1 = s1.charAt(i) + helper(s1, s2, i + 1, j);
        int deleteS2 = s2.charAt(j) + helper(s1, s2, i, j + 1);

        return dp[i][j] = Math.min(deleteS1, deleteS2);
    }
}
