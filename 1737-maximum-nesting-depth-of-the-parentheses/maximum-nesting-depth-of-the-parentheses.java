class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int ans = 0;
        int cur = 0;
        for(char c : s.toCharArray()){
            if(c == '(') cur++;
            else if(c == ')') cur--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}