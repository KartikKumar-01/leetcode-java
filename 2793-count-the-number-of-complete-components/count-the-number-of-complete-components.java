class Solution {
    class DS{
        int[] size;
        int[] parent;
        DS(int n){
            size = new int[n];
            Arrays.fill(size, 1);
            parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        int parent(int node){
            if(parent[node] == node) return node;
            return parent[node] = parent(parent[node]);
        }

        void union(int u, int v){
            int up = parent(u);
            int vp = parent(v);
            if(up == vp) return;
            if(size[up] < size[vp]){
                parent[up] = vp;
                size[vp] += size[up];
            }else{
                parent[vp] = up;
                size[up] += size[vp];
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] indeg = new int[n];
        DS ds = new DS(n);

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            ds.union(u, v);
            indeg[u]++;
            indeg[v]++;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int p = ds.parent(i);
            map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for(int component : map.keySet()){
            int k = map.get(component).size();
            boolean complete = true;
            for(int node : map.get(component)){
                if(indeg[node] != k - 1){
                    complete = false;
                    break;
                }
            }
            if(complete) ans++;
        }
        
        return ans;
        
    }
}