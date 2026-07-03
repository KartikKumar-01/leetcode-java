class Solution {
    int n;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.n = online.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int max = 0;
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
            max = Math.max(max, w);
        }
        int low = 0;
        int high = max;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(possible(adj, online, mid, k)){
                ans = mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        return ans;
    }
    private boolean possible(ArrayList<ArrayList<int[]>> adj, boolean[] online, int min, long k){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long node = cur[0];
            long cost = cur[1];

            if(cost > dist[(int)node] || cost > k) continue;

            for(int[] neigh : adj.get((int)node)){
                int v = neigh[0];
                int c = neigh[1];
                if(c < min || !online[v]) continue;
                if(cost + c < dist[v]){
                    dist[v] = cost + c;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }
        return dist[n - 1] <= k;
    }
}