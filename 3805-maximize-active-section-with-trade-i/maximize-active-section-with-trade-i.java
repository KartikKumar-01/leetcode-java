class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(char c : s.toCharArray())if(c == '1') ans++;
        int n = s.length();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == '0'){
                int c = 0;
                while(i < n && s.charAt(i) == '0'){
                    c++;
                    i++;
                }
                list.add(c);
            }
            i++;
        }
        int mx = 0;
        for(int j = 0; j < list.size() - 1; j++){
            mx = Math.max(mx, list.get(j) + list.get(j + 1));
        }
        return mx + ans;
    }
}