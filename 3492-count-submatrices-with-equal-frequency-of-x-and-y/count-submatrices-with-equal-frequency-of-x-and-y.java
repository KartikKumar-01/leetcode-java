class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] xpref = new int[n + 1][m + 1];
        int[][] pref = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int val = 0;
                if(grid[i - 1][j - 1] == 'X') val = 1;
                else if(grid[i - 1][j - 1] == 'Y') val = -1;
                pref[i][j] = pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1] + val;
                
                xpref[i][j] = xpref[i- 1][j] + xpref[i][j - 1] - xpref[i - 1][j - 1];
                if(grid[i - 1][j - 1] == 'X') xpref[i][j]++;
            }
        }
        // print(pref);
        int count = 0;
        // if(grid[0][0] != 'X') return 0;
        int x = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'X') x++;
                if(pref[i + 1][j + 1] == 0 && xpref[i + 1][j + 1] > 0) count++;
            }
        }
        return count;
    }
}