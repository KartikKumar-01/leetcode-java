class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int ans = 0;
        int[] lower = new int[26];
        Arrays.fill(lower, -1);
        int[] upper = new int[26];
        Arrays.fill(upper, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                upper[c - 'A'] = Math.min(upper[c - 'A'], i);
            }else{
                lower[c - 'a'] = Math.max(lower[c - 'a'], i);
            }
        }

        for(int i = 0; i < 26; i++){
            if(lower[i] != -1 && upper[i] != Integer.MAX_VALUE && lower[i] < upper[i]) ans++;
        }

        return ans;
    }
}