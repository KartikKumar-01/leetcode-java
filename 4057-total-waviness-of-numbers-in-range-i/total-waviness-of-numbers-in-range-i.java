class Solution {
    static int max = 100001;
    static int[] dp = new int[max];
    static int[] pref = new int[max];
    static{
        for(int i = 100; i < max; i++){
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 10;
            int wave = m > Math.max(l, r) || m < Math.min(l, r) ? 1 : 0;
            dp[i] = dp[i / 10] + wave;
            pref[i] = pref[i - 1] + dp[i];
        }
    }
    public int totalWaviness(int num1, int num2) {
        return pref[num2] - pref[num1 - 1];
    }
}