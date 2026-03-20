class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n - k + 1][m - k + 1];

        for(int i = 0; i < n - k + 1; i++){
            for(int j = 0; j < m - k + 1; j++){
                TreeSet<Integer> set = new TreeSet<>();
                for(int a = i; a < i + k; a++){
                    for(int b = j; b < j + k; b++){
                        set.add(grid[a][b]);
                    }
                }
                if(set.size() == 1){
                    ans[i][j] = 0;
                    continue;
                }
                ArrayList<Integer> list = new ArrayList<>(set);
                int val = Integer.MAX_VALUE;
                for(int a = 1; a < list.size(); a++){
                    int x = Math.abs(list.get(a) - list.get(a - 1));
                    val = Math.min(val, x);
                }
                ans[i][j] = val;
            }
        }
        return ans;
    }
}