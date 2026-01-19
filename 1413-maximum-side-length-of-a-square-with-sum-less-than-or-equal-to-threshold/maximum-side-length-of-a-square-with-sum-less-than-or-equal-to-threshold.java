class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pref[i][j] = mat[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low ) / 2;
            if(possible(mat, pref, n, m, mid, threshold)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private boolean possible(int[][] mat, int[][] pref, int n, int m, int k, int t){
        for(int i = k; i <= n; i++){
            for(int j = k; j <= m; j++){
                int sum = pref[i][j] - pref[i - k][j] - pref[i][j - k] + pref[i - k][j - k];
                if(sum <= t){
                    return true;
                }
            }
        }
        return false;
    }
}