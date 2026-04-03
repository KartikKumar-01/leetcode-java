class Solution {
    class Pair{
        int pos, d;
        Pair(int pos, int d){
            this.pos = pos;
            this.d = d;
        }
    }
    int n;
    int[] left, right;
    Integer[][] dp;
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        n = robots.length;
        Pair[] a = new Pair[n];
        for(int i = 0; i < n; i++) a[i] = new Pair(robots[i], distance[i]);

        Arrays.sort(a, (x, b) -> x.pos - b.pos);
        Arrays.sort(walls);

        left = new int[n];
        right = new int[n];
        left[0] = a[0].pos - a[0].d;
right[n - 1] = a[n - 1].pos + a[n - 1].d;
        for(int i = 1; i < n; i++){
            left[i] = Math.max(a[i].pos - a[i].d, a[i - 1].pos + 1);
        }
        for(int i = 0; i < n - 1; i++){
            right[i] = Math.min(a[i].pos + a[i].d, a[i + 1].pos - 1);
        }
        dp = new Integer[n][2];
        return solve(a, walls, 0, 0);
    }
    private int solve(Pair[] a, int[] w, int i, int d){
        if(i >= n) return 0;

        if(dp[i][d] != null) return dp[i][d];
        int ls = left[i];
        if(d == 1 && i > 0){
            ls = Math.max(right[i - 1] + 1, ls);
        }
        int leftWalls = countWalls(w, ls, a[i].pos) + solve(a, w, i + 1, 0);

        int rightWalls = countWalls(w, a[i].pos, right[i]) + solve(a, w, i + 1, 1);

        return dp[i][d] = Math.max(leftWalls, rightWalls);
    }
    private int countWalls(int[] w, int left, int right){
        return ub(w, right) - lb(w, left);
    }

    private int lb(int[] a, int x){
        int l = a.length;
        int low = 0, high = l - 1;
        int ans = l;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(a[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    private int ub(int[] a, int x){
    int low = 0, high = a.length - 1;
    int ans = a.length;
    while(low <= high){
        int mid = low + (high - low) / 2;
        if(a[mid] > x){
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}
}