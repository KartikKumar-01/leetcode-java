class Solution {
    public int countValidPrefixes(String s) {
        int n = s.length();
        int[] pref = new int[n];
        pref[0] = s.charAt(0) == '0' ? 1 : 0;

        for(int i = 1; i < n; i++) pref[i] = pref[i - 1] + (s.charAt(i) == '0' ? 1 : 0);

        int ans = 0;
        for(int i = 0; i < n; i++){
            int z = pref[i];
            int o = i + 1 - pref[i];
            if(Math.abs(o - z ) <= 1) ans++;
        }
        return ans;
    }
}