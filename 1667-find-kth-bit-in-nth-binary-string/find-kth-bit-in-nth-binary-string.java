class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        if(k <= 1) return '0';
        return solve(n, 0, "0").charAt(k - 1);
    }
    private String solve(int n, int i, String cur){
        if(i > n) return cur;
        String temp = cur;
        String inv = invert(temp);
        StringBuilder rev = new StringBuilder(inv);
        rev.reverse();
        return solve(n, i + 1, cur + "1" + rev.toString());
    }
    private String invert(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) sb.append((c == '0') ? "1" : "0");
        return sb.toString();
    }
}