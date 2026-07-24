class Solution {
    HashMap<Integer, Integer> map;
    int[] price;
    int[][] dp;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        map = new HashMap<>();
        dp = new int[n][2];
        for(int [] d : dp) Arrays.fill(d, -1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        this.price = price;
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int[] t : trips){
            dfsPath(adj, t[0], -1, t[1]);
        }
        return Math.min(dfs(adj, 0, -1, 1), dfs(adj, 0, -1, 0));
    }
    private boolean dfsPath(ArrayList<ArrayList<Integer>> adj, int node, int par, int target) {
        if (node == target) {
            map.put(node, map.getOrDefault(node, 0) + 1);
            return true;
        }

        for (int nxt : adj.get(node)) {
            if (nxt == par) continue;

            if (dfsPath(adj, nxt, node, target)) {
                map.put(node, map.getOrDefault(node, 0) + 1);
                return true;
            }
        }

        return false;
    }

        private int dfs(ArrayList<ArrayList<Integer>> adj, int i, int parent, int take){
            if(dp[i][take] != -1) return dp[i][take];
            int freq = map.getOrDefault(i, 0);

            int ans = (take == 1) ? price[i] / 2 * freq : price[i] * freq;
            for(int x : adj.get(i)){
                if(x == parent) continue;
                if(take == 1){
                    ans += dfs(adj, x, i, 0);
                }else{
                    ans += Math.min(dfs(adj, x, i, 0), dfs(adj, x, i, 1));
                }
            }            
            return dp[i][take] = ans;
        }
}