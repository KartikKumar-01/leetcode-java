class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] best = new int[n][m];
        for(int[] b : best) Arrays.fill(b, Integer.MAX_VALUE);
        best[0][0] = grid.get(0).get(0);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0, best[0][0]});

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int i = cur[0];
            int j = cur[1];
            int cost = cur[2];

            if(i == n - 1 && j == m - 1) return cost < health;

            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                if(r < 0 || r >= n || c < 0 || c >= m) continue;
                int val = grid.get(r).get(c);
                if(cost + val < best[r][c]){
                    best[r][c] = cost + val;
                    if(val == 0) dq.offerFirst(new int[]{r, c, best[r][c]});
                    else dq.offerLast(new int[]{r, c, best[r][c]});
                }
            }
        }
        return false;
    }
}