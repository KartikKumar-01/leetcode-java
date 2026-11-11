class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long one = (long)cost1 * need1;
        long second =(long) cost2 * need2;
        if(need1 == 0 && need2 == 0) return 0;
        if(costBoth >= cost1 + cost2) return one + second;
        long equal = (long)(Math.min(need1, need2));
        long three = (long)costBoth * (equal);
        long ans = three;
        ans += (need1 - equal) * cost1;
        ans += (need2 - equal) * cost2;
        return Math.min(ans, ((long)costBoth * Math.max(need1, need2)));
    }
}