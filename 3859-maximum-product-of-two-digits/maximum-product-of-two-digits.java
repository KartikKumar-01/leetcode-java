class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        int mx1 = 0, mx2 = 0;
        for(char c : s.toCharArray()){
            if((c - '0') >= mx1){
                mx2 = mx1;
                mx1 = (c - '0');
            }else if((c - '0') > mx2) mx2 = (c - '0');
        }
        return mx1 * mx2;
    }
}