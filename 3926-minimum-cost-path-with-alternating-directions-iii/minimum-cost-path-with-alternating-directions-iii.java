class Solution {
    class State{
        int r;
        int c;
        int parity;
        long cost;
        State(int r, int c, int p, long cost){
            this.r = r;
            this.c = c;
            this.parity = p;
            this.cost = cost;
        }
    }
    public long minCost(int n, int m, int[][] penalty) {
        int[][] om = {{0, 1}, {1, 0}};
        int[][] em = {{-1, 0}, {0, -1}};
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        long[][] even = new long[n][m];
        long[][] odd = new long[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(even[i], Long.MAX_VALUE);
            Arrays.fill(odd[i], Long.MAX_VALUE);
        }
        odd[0][0] = 1;
        pq.offer(new State(0, 0, 1, 1));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int p = cur.parity;
            int i = cur.r;
            int j = cur.c;
            long cost = cur.cost;

            if (p == 1 && cost != odd[i][j]) continue;
            if (p == 0 && cost != even[i][j]) continue;

            if(p == 1){
                for(int[] d : om){
                    int r = i + d[0];
                    int c = j + d[1];
                    if(r < 0 || r >= n || c < 0 || c >= m) continue;
                    int ncost = (r + 1) * (c + 1);
                    if(cost + ncost < even[r][c]){
                        even[r][c] = cost + ncost;
                        pq.offer(new State(r, c, 0, even[r][c]));
                    }
                }
                for(int[] d : em){
                    int r = i + d[0];
                    int c = j + d[1];
                    if(r < 0 || r >= n || c < 0 || c >= m) continue;
                    int ncost = penalty[i][j] +  (r + 1) * (c + 1);
                    if(cost + ncost < even[r][c]){
                        even[r][c] = cost + ncost;
                        pq.offer(new State(r, c, 0, even[r][c]));
                    }
                }
            }else{
                for(int[] d : em){
                    int r = i + d[0];
                    int c = j + d[1];
                    if(r < 0 || r >= n || c < 0 || c >= m) continue;
                    int ncost = (r + 1) * (c + 1);
                    if(cost + ncost < odd[r][c]){
                        odd[r][c] = cost + ncost;
                        pq.offer(new State(r, c, 1, odd[r][c]));
                    }
                }
                for(int[] d : om){
                    int r = i + d[0];
                    int c = j + d[1];
                    if(r < 0 || r >= n || c < 0 || c >= m) continue;
                    int ncost = penalty[i][j] +  (r + 1) * (c + 1);
                    if(cost + ncost < odd[r][c]){
                        odd[r][c] = cost + ncost;
                        pq.offer(new State(r, c, 1, odd[r][c]));
                    }
                }
            }
            // wait
            if (p == 1) {
                if (cost + penalty[i][j] < even[i][j]) {
                    even[i][j] = cost + penalty[i][j];
                    pq.offer(new State(i, j, 0, even[i][j]));
                }
            } else {
                if (cost + penalty[i][j] < odd[i][j]) {
                    odd[i][j] = cost + penalty[i][j];
                    pq.offer(new State(i, j, 1, odd[i][j]));
                }
            }
        }
        return Math.min(even[n - 1][m - 1], odd[n - 1][m - 1]);
    }
}