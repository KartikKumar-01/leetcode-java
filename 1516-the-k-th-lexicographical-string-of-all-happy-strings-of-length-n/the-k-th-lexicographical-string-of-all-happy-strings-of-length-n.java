class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if(k > total) return "";

        char[] ch = {'a', 'b', 'c'};
        char last = '#';

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(char c : ch){
                if(c == last) continue;
                int remaining = n - i - 1;
                int blockSize = 1 << remaining;
                if(k > blockSize){
                    k -= blockSize;
                }else {
                    res.append(c);
                    last = c;
                    break;
                }
            }
        }
        return res.toString();
    }
}