class Solution {
    static int[] power;
    static final long mod = 1000000007l;

    static {
        power = new int[100001];
        power[0] = 1;
        for (int i = 1; i < power.length; i++) {
            power[i] = (int) ((2L * power[i - 1]) % mod);
        }
    }
    int[] parent;
    int[] depth;
    boolean[] vis;
    int[][] up;
    int col;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int q = queries.length;
        parent = new int[n + 2];
        depth = new int[n + 2];
        vis = new boolean[n + 2];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        parent[1] = -1;
        dfs(1, adj, 0);
        createUp(n, parent);

        int[] ans = new int[q];
        for(int i = 0; i < q; i++){
            int u = queries[i][0], v = queries[i][1];
            int dist = depth[u] + depth[v] - 2 * depth[lca(u, v)];
            ans[i] = dist == 0 ? 0 : power[dist - 1];
        }
        return ans;
    }

    private int lca(int u, int v){
        int du = depth[u];
        int dv = depth[v];
        if(du < dv) {
            int temp = u;
            u = v;
            v = temp;

            temp = du;
            du = dv;
            dv = temp;
        }

        int diff = du - dv;
        u = getAncestor(u, diff);
        if(u == v) return u;

        for(int j = col - 1; j >= 0; j--){
            if(up[u][j] == -1) continue;
            if(up[u][j] != up[v][j]){
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    private void createUp(int n, int[] parent){
        col = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[n + 2][col];
        for(int[] u : up) Arrays.fill(u, -1);
        for(int i = 1; i <= n; i++) up[i][0] = parent[i];

        for(int j = 1; j < col; j++){
            for(int i = 1; i <= n; i++){
                if(up[i][j - 1] != -1)
                    up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
    }

    private int getAncestor(int node, int k){
        for(int b = 0; b < col; b++){
            if((k & (1 << b)) != 0){
                node = up[node][b];
            }
        }
        return node;
    }

    private void dfs(int i, List<List<Integer>> adj, int d){
        vis[i] = true;
        depth[i] = d;
        for(int next : adj.get(i)){
            if(!vis[next]){
                parent[next] = i;
                dfs(next, adj, d + 1);
            }
        }
    }
}