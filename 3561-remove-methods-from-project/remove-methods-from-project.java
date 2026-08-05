class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());
        for(int[] e : invocations){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[n];
        dfs(adj, k, vis);
        List<Integer> res = new ArrayList<>();

        for(int[] e: invocations){
            int u = e[0], v = e[1];
            if(!vis[u] && vis[v]){
                for(int i = 0;i < n; i++){
                    res.add(i);
                }
                return res;
            }
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]) res.add(i);
        }
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis){
        vis[i] = true;
        for(int next : adj.get(i)){
            if(!vis[next]){
                dfs(adj, next, vis);
            }
        }
    }

}