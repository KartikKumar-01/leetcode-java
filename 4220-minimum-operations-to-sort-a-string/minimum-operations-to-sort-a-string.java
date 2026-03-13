class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        int cmn = 0, cmx = 0;
        char mn = 'z', mx = 'a';
        for(int i = 0; i < n; i++){
            if(i > 0 && s.charAt(i) < s.charAt(i - 1)) sorted = false;
            if(s.charAt(i) < mn){
                mn = s.charAt(i);
            }
            if(s.charAt(i) > mx){
                mx = s.charAt(i);
            }
        }
        for(char c : s.toCharArray()){
            if(c == mn) cmn++;
            if(c == mx) cmx++;
        }
        if(sorted) return 0;
        if(n <= 2) return -1;
        if(s.charAt(0) == mn || s.charAt(n - 1) == mx) return 1;
        if(s.charAt(0) == mx && cmx == 1 && s.charAt(n - 1) == mn && cmn == 1) return 3;
        return 2;
    }
}