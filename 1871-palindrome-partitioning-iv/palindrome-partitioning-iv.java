class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] pallin = new boolean[n][n];
        for(int i = 0; i < n; i++)
            pallin[i][i] = true;
        for(int len = 2; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    pallin[i][j] = (len == 2) || pallin[i + 1][j - 1];
                }
            }
        }

        for(int i = 0; i < n - 2; i++){
            if(!pallin[0][i]) continue;
            for(int j = i + 1; j < n - 1; j++){
                if(pallin[i + 1][j] && pallin[j + 1][n - 1]) return true;
            }
        }
        return false;
    }
}