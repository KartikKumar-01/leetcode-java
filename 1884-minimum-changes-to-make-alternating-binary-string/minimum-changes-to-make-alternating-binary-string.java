class Solution {
    public int minOperations(String s) {
        int op = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((i & 1) == 1 && c != '0') op++;
            else if((i & 1) != 1 && c != '1') op++;
        }
        int ans = op;
        op = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((i & 1) == 1 && c == '0') op++;
            else if((i & 1) != 1 && c == '1') op++;
        }
        return Math.min(ans, op);
    }
}