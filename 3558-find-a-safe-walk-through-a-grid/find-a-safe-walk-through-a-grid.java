class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] best = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int sh = health - grid.get(0).get(0);
        if(sh < 1) return false;

        q.offer(new int[]{0, 0, sh});
        best[0][0] = sh;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int h = cur[2];

            if(i == n - 1 && j == m - 1) return true;
            
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                if(r < 0 || r >= n || c < 0 || c >= m) continue;
                int nh = h - grid.get(r).get(c);
                if(nh < 1) continue;

                if(nh <= best[r][c]) continue;
                best[r][c] = nh;
                q.offer(new int[]{r, c, nh});
                
            }
        }
        return false;
    }
}