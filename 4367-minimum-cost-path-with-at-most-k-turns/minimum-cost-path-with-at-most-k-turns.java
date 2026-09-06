class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][][][] best = new int[n + 1][m + 1][5][k + 1];
        for(int[][][] a : best)
            for(int[][] b : a)
                for(int[] c : b) Arrays.fill(c, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[4], y[4]));
        best[0][0][4][0] = grid[0][0];

        pq.offer(new int[]{0, 0, 4, 0, grid[0][0]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int d = cur[2];
            int turns = cur[3];
            int cost = cur[4];

            if(cost != best[i][j][d][turns]) continue;

            if(i == n - 1 && j == m - 1) return cost;

            for(int newd = 0; newd < 4; newd++){
                int r = i + dir[newd][0];
                int c = j + dir[newd][1];
                if(r < 0 || r >= n || c < 0 || c >= m) continue;

                int nturns = turns;
                if(d != 4 && newd != d) nturns++;
                if(nturns > k) continue;

                int ncost = cost + grid[r][c];

                if(ncost < best[r][c][newd][nturns]){
                    best[r][c][newd][nturns] = ncost;

                    pq.offer(new int[]{r, c, newd, nturns, ncost});
                }
            }
        }
        return -1;
    }
}