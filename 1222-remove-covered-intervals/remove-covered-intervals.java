class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        int n = intervals.length;
        int ans = n;

        int[] prev = intervals[0];
        for(int i = 1; i < n; i++){
            int[] it = intervals[i];
            if(prev[0] <= it[0] && it[1] <= prev[1]) ans--;
            else prev = it;
        }
        return ans;
    }
}