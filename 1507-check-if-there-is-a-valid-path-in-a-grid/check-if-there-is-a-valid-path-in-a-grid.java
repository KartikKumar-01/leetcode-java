import java.util.*;

class Solution {
    int n, m;

    public boolean hasValidPath(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;

        HashMap<Integer, List<int[]>> map = new HashMap<>();

        map.put(1, Arrays.asList(new int[]{0,1}, new int[]{0,-1}));
        map.put(2, Arrays.asList(new int[]{1,0}, new int[]{-1,0}));
        map.put(3, Arrays.asList(new int[]{0,-1}, new int[]{1,0}));
        map.put(4, Arrays.asList(new int[]{0,1}, new int[]{1,0}));
        map.put(5, Arrays.asList(new int[]{0,-1}, new int[]{-1,0}));
        map.put(6, Arrays.asList(new int[]{0,1}, new int[]{-1,0}));

        return dfs(grid, 0, 0, map, new boolean[n][m]);
    }

    private boolean dfs(int[][] grid, int i, int j, HashMap<Integer, List<int[]>> map, boolean[][] vis) {

        if(i == n - 1 && j == m - 1) return true;

        vis[i][j] = true;

        for(int[] d : map.get(grid[i][j])) {
            int r = i + d[0];
            int c = j + d[1];

            if(r < 0 || r >= n || c < 0 || c >= m || vis[r][c]) continue;

            for(int[] back : map.get(grid[r][c])) {
                if(r + back[0] == i && c + back[1] == j) {
                    if(dfs(grid, r, c, map, vis)) return true;
                }
            }
        }
        return false;
    }
}