class Solution {
    String result = "";
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        solve(new StringBuilder(), 0, freq, target, false);
        return result;
    }
    public boolean solve(StringBuilder cur, int i, int[] freq, String target, boolean greater){
        if(i == target.length()){
            if(greater){
                result = cur.toString();
                return true;
            }
            return false;
        }

        for(char c = 'a'; c <= 'z'; c++){
            if(freq[c - 'a'] == 0)continue;
            if(!greater && c < target.charAt(i)) continue;

            cur.append(c);
            freq[c - 'a']--;
            boolean isGreater = greater || (c > target.charAt(i));
            if(solve(cur, i + 1, freq, target, isGreater)) return true;
            cur.deleteCharAt(cur.length() - 1);
            freq[c - 'a']++;
        }
        return false;
    }
}