class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;
        DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int findUlParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findUlParent(parent[node]);
        }
        public void union(int u, int v){
            int uu = findUlParent(u);
            int uv = findUlParent(v);
            if(uu == uv) return;
            if(rank[uu] < rank[uv]){
                parent[uu] = uv;
            }
            else if(rank[uv] < rank[uu]){
                parent[uv] = uu;
            }
            else{
                parent[uu] = uv;
                rank[uv]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n + 1);
        ArrayList<int[]> list = new ArrayList<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int uu = ds.findUlParent(u);
            int uv = ds.findUlParent(v);
            if(uu == uv){
                list.add(new int[]{u, v});
            }
            else{
                ds.union(u, v);
            }
        }
        return list.get(list.size() - 1);
    }
}