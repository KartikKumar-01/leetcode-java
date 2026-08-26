class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int n = s.length();
        int i = 0;
        int count = 0;
        for(int j = 0; j < n; j++){
            if(s.charAt(j) == '1') count++;

            while(count > k){
                char l = s.charAt(i);
                if(l == '1') count--;
                i++;
            }
            while (count == k && s.charAt(i) == '0') {
                i++;
            }
            if(count == k){
                String sub = s.substring(i, j + 1);
                if(ans.equals("") || sub.length() < ans.length() || (sub.length() == ans.length() && sub.compareTo(ans) < 0)){
                    ans = sub;
                }
            }
        }
        
        return ans;
    }
}