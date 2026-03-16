class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int[][] dir = {{1, 1}, {-1, 1}, {1, -1}, {-1, 1}};
        int n = grid.length;
        int m = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                set.add(grid[i][j]);
                if(set.size() > 3)
                        set.pollFirst();
                for(int s = 1;; s++){
                    if(i - s < 0 || i + s >= n || j - s < 0 || j + s >= m) break;
                    int area = 0;
                    for(int k = 0; k < s; k++) area += grid[i - s + k][j + k];
                    for(int k = 0; k < s; k++) area += grid[i + k][j + s - k];
                    for(int k = 0; k < s; k++) area += grid[i + s - k][j - k];
                    for(int k = 0; k < s; k++) area += grid[i - k][j - s + k];
                    set.add(area);
                    if(set.size() > 3) set.pollFirst();
                }
            }
        }
        int[] ans = new int[set.size()];
        int idx = set.size() - 1;

        for(int val : set)
            ans[idx--] = val;
        return ans;
    }
}