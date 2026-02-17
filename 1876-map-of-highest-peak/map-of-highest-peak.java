class Solution {
    public boolean inLimits(int i, int j, int n, int m){
        return i >= 0 && j >= 0 && i < n && j < m;
    }
    public int[][] highestPeak(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] ans = new int[n][m];
        for(int[] a : ans) Arrays.fill(a, -1);

        Queue<int[]> q = new LinkedList<>(); 

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            int val = ans[i][j];
            for(int[] d : dir){
                int r = i + d[0];
                int c = j + d[1];
                if(inLimits(r, c, n, m) && ans[r][c] == -1 && (ans[r][c] != 0 || ans[r][c] != val)){
                    q.offer(new int[]{r, c});
                    ans[r][c] = val + 1;
                }
            }
        }
        return ans;
    }
}