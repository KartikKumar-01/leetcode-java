class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int x : rooms.get(cur)){
                if(!vis[x]){
                    vis[x] = true;
                    q.offer(x);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}