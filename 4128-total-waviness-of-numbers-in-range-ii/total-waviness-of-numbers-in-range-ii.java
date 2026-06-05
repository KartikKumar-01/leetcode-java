class Solution {
    String s;
    int n;
    long[][][] dpNums;
    long[][][] dpWaves;
    public long totalWaviness(long num1, long num2) {
        return fun(num2) - fun(num1 - 1);
    }
    private long fun(long num){
        if(num < 100) return 0;

        s = String.valueOf(num);
        n = s.length();

        dpNums = new long[16][10][10];
        for(long[][] d : dpNums) for(long[] a : d) Arrays.fill(a, -1);
        dpWaves = new long[16][10][10];
        for(long[][] d : dpWaves) for(long[] a : d) Arrays.fill(a, -1);

        long[] ans = solve(0, -1, -1, 1, 1);
        return ans[1];
    }
    private long[] solve(int i, int prevPrev, int prev, int isLimited, int leadingZeroes){
        if(i == n) return new long[]{1, 0};
        long totalNumbers = 0;
        long totalWaviness = 0;

        if(isLimited != 1 && leadingZeroes != 1 && prev >= 0 && prevPrev >= 0){
            if(dpNums[i][prevPrev][prev] != -1 && dpWaves[i][prevPrev][prev] != -1){
                return new long[]{dpNums[i][prevPrev][prev], dpWaves[i][prevPrev][prev]};
            }
        }

        int limit = isLimited == 1 ? s.charAt(i) - '0' : 9;

        for(int digit = 0; digit <= limit; digit++){
            int newIsLeadingZeroes = leadingZeroes == 1 && digit == 0 ? 1 : 0;
            int newPrevPrev = prev;
            int newPrev = newIsLeadingZeroes == 1 ? -1 : digit;
            int newIsLimited = isLimited == 1 && digit == limit ? 1 : 0;
            long[] cur = solve(i + 1, newPrevPrev, newPrev, newIsLimited, newIsLeadingZeroes);

            if(leadingZeroes != 1 && prev >= 0 && prevPrev >= 0){
                boolean isPeak = prev > Math.max(prevPrev, digit);
                boolean isValley = prev < Math.min(prevPrev, digit);
                if(isPeak || isValley){
                    totalWaviness += cur[0];
                }
            }
            totalNumbers += cur[0];
            totalWaviness += cur[1];
        }

        if(isLimited != 1 && leadingZeroes != 1 && prev >= 0 && prevPrev >= 0){
            dpNums[i][prevPrev][prev] = totalNumbers;
            dpWaves[i][prevPrev][prev] = totalWaviness;
        }

        return new long[]{totalNumbers, totalWaviness};
    }
}