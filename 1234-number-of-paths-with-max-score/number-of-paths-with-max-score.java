class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int MOD = (int) 1e9 + 7;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] dir = {{1,0},{0,1},{1,1}};

        int[][] sum = new int[n + 1][n + 1];
        for(int[] s : sum) Arrays.fill(s, -1);
        int[][] cnt = new int[n + 1][n + 1];
        sum[n - 1][n - 1] = 0;
        cnt[n - 1][n - 1] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(board.get(i).charAt(j) == 'X') continue;
                if(i == n - 1 && j == n - 1) continue;

                int best = -1;
                int ct = 0;

                for(int[] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    if(r == n || c == n) continue;
                    if(sum[r][c] == -1) continue;

                    if (sum[r][c] > best) {
                        best = sum[r][c];
                        ct = cnt[r][c];
                    }else if(best == sum[r][c]){
                        ct = (ct + cnt[r][c])% MOD;
                    }
                }
                char ch = board.get(i).charAt(j);
                int val = (ch >= '1' && ch <= '9') ? ch - '0' : 0;
                if (best == -1) continue;

                sum[i][j] = best + val;
                cnt[i][j] = ct;
            }
        }

        if (sum[0][0] == -1)
            return new int[]{0, 0};

        return new int[]{sum[0][0], cnt[0][0]};


        // dfs(board, n - 1, n - 1, 0);
        // if (map.isEmpty()) return new int[]{0, 0};

        // int sum = -1;
        // int cnt = 0;
        // for(int key : map.keySet()){
        //     if(key > sum){
        //         sum = key;
        //         cnt = map.get(key);
        //     }
        // }
        // return new int[]{sum, cnt % MOD};
    }
    private void dfs(List<String> board, int i, int j, int sum){
        if(i < 0 || j < 0 || j >= board.size() || i >= board.size() || board.get(i).charAt(j) == 'X') return;
        if(i == 0 && j == 0){
            map.put(sum, (map.getOrDefault(sum, 0) + 1) % MOD);
            return;
        }
        char c = board.get(i).charAt(j);
        if(c >= '1' && c <= '9')
            sum += board.get(i).charAt(j) - '0';
        dfs(board, i - 1, j, sum);
        dfs(board, i - 1, j - 1, sum);
        dfs(board, i, j - 1, sum);
    }
}