class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] a = new int[n * m];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[k++] = grid[i][j];
            }
        }
        Arrays.sort(a);
        int z = a[0];
        for(int y : a){
            if(Math.abs(z - y) % x != 0)return -1;
        }

        int median = a[a.length / 2];
        int ans = 0;
        for(int val : a){
            ans += Math.abs(val - median) / x;
        }
        return ans;
    }
}