class Solution {
    private boolean valid(int i, int j, int n){
        return i >= 0 && j >= 0 && i < n && j < n;
    }
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                int h = grid[i][j];
                if(h == 0) continue;

                int sa = 4*h + 2;
                for(int[] d : dir){
                    int r = d[0] + i;
                    int c = d[1] + j;
                    if(valid(r, c, n)){
                        sa -= Math.min(h, grid[r][c]);
                    }
                }
                ans += sa;

            }
        }
        return ans;
    }
}