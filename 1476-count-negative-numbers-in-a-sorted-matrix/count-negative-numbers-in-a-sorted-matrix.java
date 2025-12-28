class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int[] row : grid){
            int count = helper(row);
            res += count;
        }
        return res;
    }
    private int helper(int[] row){
        int n = row.length;
        int low = 0, high = n - 1;
        int idx = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(row[mid] < 0){
                idx = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        // System.out.println(idx);
        return n - idx;
    }
}