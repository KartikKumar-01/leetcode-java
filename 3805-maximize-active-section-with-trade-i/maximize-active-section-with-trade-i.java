class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(char c : s.toCharArray())if(c == '1') ans++;
        int n = s.length();
        int i = 0;
        int prev = 0;
        int mx = 0;
        while(i < n){
            if(s.charAt(i) == '0'){
                int c = 0;
                while(i < n && s.charAt(i) == '0'){
                    c++;
                    i++;
                }
                if(prev != 0) mx = Math.max(mx, prev + c);
                prev = c;
            }
            i++;
        }
        return mx + ans;
    }
}