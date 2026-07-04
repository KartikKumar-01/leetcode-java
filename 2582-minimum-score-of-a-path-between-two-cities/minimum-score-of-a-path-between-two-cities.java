class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, adj, vis);

        return ans;
    }

    private void dfs(int node, List<List<int[]>> adj, boolean[] vis) {
        vis[node] = true;

        for (int[] next : adj.get(node)) {
            ans = Math.min(ans, next[1]);

            if (!vis[next[0]]) {
                dfs(next[0], adj, vis);
            }
        }
    }
}