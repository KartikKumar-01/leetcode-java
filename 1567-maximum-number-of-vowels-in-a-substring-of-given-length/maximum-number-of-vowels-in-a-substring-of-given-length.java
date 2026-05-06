class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int[] vowels = new int['z' + 1];
        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = 1;
        int count = 0;
        int ans = 0;
        int i = 0;
        for(int j = 0; j < n; j++){
            char c = s.charAt(j);
            if(vowels[c] == 1) count++;
            if(j - i + 1 > k){
                char l = s.charAt(i);
                if(vowels[l] == 1) count--;
                i++;
            }
            if(j - i + 1 == k) {
                // System.out.println(i + " " + j + " " + count);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}