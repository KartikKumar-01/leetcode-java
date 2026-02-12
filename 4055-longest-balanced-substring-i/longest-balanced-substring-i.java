class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            int distinct = 0;

            for(int j = i; j < n; j++){
                int id = s.charAt(j) - 'a';

                if(freq[id] == 0) distinct++;
                freq[id]++;

                int len = j - i + 1;
                if(len % distinct == 0){
                    int t = len / distinct;
                    if(valid(freq,t, distinct)){
                        ans = Math.max(len, ans);
                    }
                }
            }
        }
        return ans;
    }
    private boolean valid(int[] freq, int t, int d){
        int count = 0;
        for(int x : freq){
            if(x == 0) continue;
            if(x != t) return false;
            count++;
        }
        return count == d;
    }
}