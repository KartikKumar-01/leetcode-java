class Solution {
    int la;
    int lb;
    int lt;
    int MOD = (int) 1e9 + 7;
    Long[][][][] dp;
    HashMap<Character, ArrayList<Integer>> ma;
    HashMap<Character, ArrayList<Integer>> mb;
    public int interleaveCharacters(String word1, String word2, String target) {
        la = word1.length();
        lb = word2.length();
        lt = target.length();
        dp = new Long[lt + 1][la + 1][lb + 1][4];
        ma = new HashMap<>();
        mb = new HashMap<>();

        for(int i = 0; i < la; i++){
            char c = word1.charAt(i);
            ma.computeIfAbsent(c, a -> new ArrayList<>()).add(i);
        }
        for(int i = 0; i < lb; i++){
            char c = word2.charAt(i);
            mb.computeIfAbsent(c, a -> new ArrayList<>()).add(i);
        }
        return (int)(solve(word1, word2, target, 0, -1, -1, 0) % MOD);
    }
    private long solve(String a, String b, String t, int i, int pai, int pab, int mask){
        if(i == lt && pai != -1 && pab != -1) return 1;
        if(i >= lt) return 0;
        if(dp[i][pai + 1][pab + 1][mask] != null) return dp[i][pai + 1][pab + 1][mask];
        char c = t.charAt(i);
        long ans = 0;
        // for(int j = pai + 1; j < la; j++){
        //     if(a.charAt(j) == c){
        //         ans = (ans + solve(a, b, t, i + 1, j, pab)) % MOD;
        //     }
        // }
        ArrayList<Integer> al = ma.getOrDefault(c, null);
        if(al != null){
            for(int idx : al){
                if(idx <= pai) continue;
                ans = (ans + solve(a, b, t, i + 1, idx, pab, mask | 1)) % MOD;
            }
        }
        // for(int j = pab + 1; j < lb; j++){
        //     if(b.charAt(j) == c){
        //         ans = (ans + solve(a, b, t, i + 1, pai, j)) % MOD;
        //     }
        // }

        ArrayList<Integer> bl = mb.getOrDefault(c, null);
        if(bl != null){
            for(int idx : bl){
                if(idx <= pab) continue;
                ans = (ans + solve(a, b, t, i + 1, pai, idx, mask | 2)) % MOD;
            }
        }
        dp[i][pai + 1][pab + 1][mask] = ans;
        return ans;
    }
}