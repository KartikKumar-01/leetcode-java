class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        String vowels = "aeiou";
        int count = 0;
        int ans = 0;
        int i = 0;
        for(int j = 0; j < n; j++){
            char c = s.charAt(j);
            if(vowels.indexOf(c + "") != -1) count++;
            if(j - i + 1 > k){
                char l = s.charAt(i);
                if(vowels.indexOf(l + "") != -1) count--;
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