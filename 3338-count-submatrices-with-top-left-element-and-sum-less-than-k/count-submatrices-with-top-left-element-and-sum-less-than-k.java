class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] row = new int[n + 1][m + 1];
        int[][] pref = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                row[i][j] = row[i][j - 1] + grid[i - 1][j - 1];
            }
        }
        // print(row);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pref[i][j] = pref[i - 1][j] + row[i][j];
            }
        }
        // print(pref);
        int count = 0;
        if(grid[0][0] > k) return 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pref[i + 1][j + 1] <= k) count++;
            }
        }
        return count;
    }
    // private void print(int[][] a){
    //     for(int[] x : a){
    //         System.out.println(Arrays.toString(x));
    //     }
    // }
}