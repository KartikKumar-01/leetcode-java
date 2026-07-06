class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] pref = new int[n];
        int[] suf = new int[n];

        Arrays.fill(pref, -1);
        Arrays.fill(suf, -1);

        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < m && s.charAt(i) != t.charAt(j)) j++;
            if(j == m) break;
            pref[i] = j;
            j++;
        }
        j = m - 1;
        for(int i = n - 1; i >= 0; i--){
            while(j >=0 && s.charAt(i) != t.charAt(j)) j--;
            if(j < 0) break;
            suf[i] = j;
            j--;
        }

        for(int i = 0; i < n; i++){
            int p = (i == 0) ? -1 : pref[i - 1];
            int sf = (i == n - 1) ? m : suf[i + 1];
            boolean validp = (i == 0 || p != -1);
            boolean validsf = (i == n - 1 || sf != -1);
            if(validp && validsf && sf > p + 1) return true;
        }
        return false;
    }
}