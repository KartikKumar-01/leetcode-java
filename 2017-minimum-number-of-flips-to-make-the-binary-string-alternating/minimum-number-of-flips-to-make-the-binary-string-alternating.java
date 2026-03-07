class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int i = 0; 
        int j = 0;
        int a = 0;
        int b = 0;
        int ans = Integer.MAX_VALUE;
        while(j < 2 * n){
            char x = (j % 2 == 1) ? '1' : '0';
            char y = (j % 2 == 1) ? '0' : '1';
            if(s.charAt(j % n) != x) a++;
            if(s.charAt(j % n) != y) b++;

            if(j - i + 1 > n){
                x = (i % 2 == 1) ? '1' : '0';
                y = (i % 2 == 1) ? '0' : '1';
                if(s.charAt(i % n) != x) a--;
                if(s.charAt(i % n) != y) b--;
                i++;
            } 
            if(j - i + 1 == n) ans = Math.min(ans, Math.min(a, b));
            j++;
        }
        return ans;
    }
}