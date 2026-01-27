class Solution {
    class Pair{
        int v;
        long wt;
        Pair(int v, long wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, 2 * wt));
        }

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;


        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.wt, b.wt));

        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.v;
            long cost = curr.wt;

            if(cost > dist[u]) continue;

            for(Pair p : graph.get(u)){
                int v = p.v;
                long ncost = p.wt + cost;
                if(ncost < dist[v]){
                    dist[v]= ncost;
                    pq.add(new Pair(v, ncost));
                }
            }
        }
        long ans = dist[n - 1];
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}