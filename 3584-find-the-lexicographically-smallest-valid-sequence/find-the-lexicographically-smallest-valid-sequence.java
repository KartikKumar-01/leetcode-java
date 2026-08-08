class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();
        int[] suf = new int[m];
        Arrays.fill(suf, -1);
        int p = m - 1;
        for(int i = n - 1; i >= 0 && p >= 0; i--){
            if(w1.charAt(i) == w2.charAt(p)){
                suf[p] = i;
                p--;
            }
        }

        
        int[] ans = new int[m];
        int i = 0, j= 0;
        int k = 0;
        boolean skip = true;
        while(i < n && j < m){
            if(w1.charAt(i) == w2.charAt(j)){
                ans[k++] = i;
                i++; j++;
            }else if(skip && (j == m - 1 || suf[j + 1] > i)){
                ans[k++] = i;
                i++; j++;
                skip = false;
            }else i++;
        }
        if(j == m) return ans;
        return new int[0];
    }
}