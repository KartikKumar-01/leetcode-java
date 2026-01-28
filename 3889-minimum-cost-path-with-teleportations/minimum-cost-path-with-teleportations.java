class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dist = new int[n][m][k + 1];
        for(int[][] d2 : dist){
            for(int[] d1 : d2){
                Arrays.fill(d1, Integer.MAX_VALUE);
            }
        }

        List<int[]> vals = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                vals.add(new int[]{grid[i][j], i, j});
            }
        }
        vals.sort(Comparator.comparingInt(a -> a[0]));

        int[][] pos = new int[n][m]; //position of value of cell in the vals array;

        for(int i = 0; i < n * m; i++){
            int[] v = vals.get(i);
            pos[v[1]][v[2]] = i;
        }

        int[][] sortedDist = new int[k + 1][n * m];
        int[][] prefixMin = new int[k + 1][n * m];

        for(int t = k; t >= 0; t--){
            if(t != k){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        int idx = upperBound(vals, new int[]{grid[i][j], n, m}) - 1;
                        if(idx >= 0){
                            dist[i][j][t] = Math.min(dist[i][j][t], prefixMin[t + 1][idx]);
                        }
                    }
                }
            }

            dist[n - 1][m - 1][t] = 0;

            for(int i = n - 1; i >= 0; i--){
                for(int j = m - 1; j >= 0; j--){
                    if(dist[i][j][t] == Integer.MAX_VALUE) continue;
                    if(i > 0){
                        dist[i - 1][j][t] = Math.min(dist[i-1][j][t], dist[i][j][t] + grid[i][j]);
                    }

                    if(j > 0){
                        dist[i][j-1][t] = Math.min(dist[i][j-1][t], dist[i][j][t] + grid[i][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sortedDist[t][pos[i][j]] = dist[i][j][t];
                }
            }

            prefixMin[t][0] = sortedDist[t][0];
            for (int idx = 1; idx < n * m; idx++) {
                prefixMin[t][idx] = Math.min(prefixMin[t][idx - 1], sortedDist[t][idx]);
            }
        }

        return dist[0][0][0];
    }
     private int upperBound(List<int[]> vals, int[] key) {
        int lo = 0, hi = vals.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int[] v = vals.get(mid);
            if (v[0] < key[0] || (v[0] == key[0] && (v[1] < key[1] || (v[1] == key[1] && v[2] < key[2])))) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}