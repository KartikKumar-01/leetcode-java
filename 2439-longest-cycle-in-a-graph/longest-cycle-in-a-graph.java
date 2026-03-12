class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int ans = -1;

        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            HashMap<Integer, Integer> map = new HashMap<>();
            int node = i;
            int len = 0;
            while(node != -1){
                if(map.containsKey(node)){
                    ans = Math.max(ans, len - map.get(node));
                }
                if(vis[node]) break;
                vis[node] = true;
                map.put(node, len++);

                node = edges[node];
            }
        }
        return ans;
    }
}