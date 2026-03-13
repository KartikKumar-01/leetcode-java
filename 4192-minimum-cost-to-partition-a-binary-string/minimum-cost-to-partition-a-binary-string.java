class Solution {
    int ec;
    int fc;
    long[] pref;
    HashMap<String, Long> map;
    public long minCost(String s, int encCost, int flatCost) {
        int n =s.length();
        pref = new long[n + 1];
        ec = encCost;
        fc = flatCost;
        map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            pref[i] = pref[i - 1] + (s.charAt(i - 1) == '1' ? 1L : 0L);
        }
        return solve(s, 0, n);
    }
    private long solve(String s, int l, int len){
        String key = l + " " + len;
        if(map.containsKey(key)) return map.get(key);
        long one = pref[l + len] - pref[l];
        long cost;
        if(one == 0){
            cost = (long)fc;
        }
        else {
            cost = len * one * (long)ec;
        }
        long ans = cost;
        if(len % 2 == 0){
            int half = len / 2;
            long left = solve(s, l, half);
            long right = solve(s, l + half, half);
            ans = Math.min(ans, left + right);
        }
        map.put(key, ans);
        return ans;
    }
}