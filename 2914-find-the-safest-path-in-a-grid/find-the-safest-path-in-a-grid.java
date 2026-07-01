class Solution {
    List<List<Integer>> grid;
    int n;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.grid = grid;
        this.n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        boolean[][] vis = new boolean[n][n];
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int steps = cur[2];
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                if(r >= 0 && r < n && c >= 0 && c < n && !vis[r][c]){
                    dist[r][c] = steps + 1;
                    vis[r][c] = true;
                    q.offer(new int[]{r, c, steps + 1});
                }
            }
        }

        vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{dist[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int val = cur[0];
            int i = cur[1];
            int j = cur[2];

            if(vis[i][j]) continue;
            vis[i][j] = true;

            if(i == n - 1 && j == n - 1) return val;
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                if(r >= 0 && r < n && c >= 0 && c < n && !vis[r][c]){
                    int newval = Math.min(val, dist[r][c]);
                    pq.offer(new int[]{newval, r, c});
                }
            }

        }
        return 0;
    }
}