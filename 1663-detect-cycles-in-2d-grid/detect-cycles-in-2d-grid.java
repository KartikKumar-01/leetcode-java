class Solution {
    class Pair{
        int[] node;
        int[] parent;
        Pair(int i, int j, int r, int c){
            node = new int[]{i, j};
            parent = new int[]{r, c};
        }
    }
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j]){
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j, -1, -1));
                    vis[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.peek().node;
                        int[] parent = q.peek().parent;
                        q.poll();
                        for(int[] d : dir){
                            int r = d[0] + cur[0];
                            int c = d[1] + cur[1];
                            if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == grid[cur[0]][cur[1]]){
                                if(!vis[r][c]) {
                                    vis[r][c] = true;
                                    q.offer(new Pair(r, c,  cur[0], cur[1]));
                                }else if(!(r == parent[0] && c == parent[1])) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}