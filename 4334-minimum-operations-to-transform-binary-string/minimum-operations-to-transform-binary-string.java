class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        if(s1.equals("1") && s2.equals("0")) return -1;

        char[] ch = s1.toCharArray();
        int res = 0;
        for(int i = 0; i < n; i++){
            if(ch[i] == s2.charAt(i)) continue;
            else if(ch[i] == '0'){
                res++;
            }else if(i < n - 1){
                res += ch[i + 1] == '1' ? 1 : 2;
                ch[i + 1] = '0';
            }else {
                res += 2;
            }
        }
        return res;
    }
}

