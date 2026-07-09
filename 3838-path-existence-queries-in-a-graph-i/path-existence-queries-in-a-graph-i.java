class Solution {
    class DS{
        int[] rank;
        int[] parent;
        DS(int n){
            rank = new int[n];
            parent = new int[n];
            for(int i= 0; i < n; i++) parent[i] = i;
        }
        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }
        public void union(int x, int y){
            int ux = findParent(x);
            int uy = findParent(y);
            if(ux == uy) return;
            if(rank[ux] < rank[uy]){
                parent[ux] = uy;
            }else if(rank[uy] < rank[ux]){
                parent[uy] = ux;
            }else{
                parent[uy] = ux;
                rank[ux]++;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DS ds = new DS(n);
        for(int i = 0; i < n - 1; i++){
            if(nums[i + 1] - nums[i] <= maxDiff){
                ds.union(i, i + 1);
            }
        }
        int ql = queries.length;
        boolean[] ans = new boolean[ql];
        for(int i = 0; i < ql; i++){
            int[] q = queries[i];
            int f = ds.findParent(q[0]);
            int s = ds.findParent(q[1]);
            ans[i] = f == s;
        }
        return ans;
    }
}