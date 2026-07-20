class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        while(k-- > 0){
        int[][] a = new int[n][m];
        a[0][0] = grid[n - 1][m - 1];
            for(int i = 0; i < n; i++){
                    if(i != 0) a[i][0] = grid[i - 1][m - 1];
                for(int j = 1; j < m; j++){
                    a[i][j] = grid[i][j - 1];
                }
            }
            grid = a;
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int[] x : grid){
            List<Integer> list = new ArrayList<>();
            for(int num : x) list.add(num);
            res.add(list);
        }
        return res;
    }
}