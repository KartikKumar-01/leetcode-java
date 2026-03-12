class Solution {
    class DSU{
        int n;
        int[] parent;
        int[] rank;
        DSU(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int parent(int x){
            if(parent[x] != x) parent[x] = parent(parent[x]);
            return parent[x];
        }
        public boolean union(int u, int v){
            int pu = parent(u);
            int pv = parent(v);
            if(pu == pv) return false;
            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }
            else if(rank[pv] < rank[pu]){
                parent[pv] = pu;
            }
            else{
                parent[pu] = pv;
                rank[pv]++;
            }
            return true;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        int low = 0;
        int high = 0;
        for(int[] e : edges) high = Math.max(high, e[2] * 2);
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(possible(n, edges, k, mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private boolean possible(int n, int[][] edges, int k, int mid){
        DSU ds = new DSU(n);
        int edgesUsed = 0;
        int upgrades = 0;
        ArrayList<int[]> needUpgrade = new ArrayList<>();

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];
            if(must == 1){
                if(s < mid) return false;
                if(!ds.union(u, v)) return false;
                edgesUsed++;
            }
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];
            if(must == 1){
                continue;
            }
            if(s >= mid){
                if(ds.union(u, v)) edgesUsed++;
            }else if(s * 2 >= mid){
                needUpgrade.add(e);
            }
        }

        for(int[] e : needUpgrade){
            int u = e[0], v = e[1];
            if(ds.union(u, v)){
                upgrades++;
                edgesUsed++;
            }
            if(upgrades > k) return false;
        }
        return edgesUsed == n - 1;
    }
}