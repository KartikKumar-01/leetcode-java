class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] oi, int fs, int fe) {
        List<int[]> list = new ArrayList<>();
        int n = oi.length;
        Arrays.sort(oi, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        int[] prev = oi[0];

        for(int i = 1; i < n; i++){
            int[] interval = oi[i];
            if(interval[0] <= prev[1] + 1){
                prev[0] = Math.min(interval[0], prev[0]);
                prev[1] = Math.max(interval[1], prev[1]);
            }else{
                list.add(prev);
                prev = interval;
            }
        }
        list.add(prev);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            int[] cur = list.get(i);
            if (cur[1] < fs || cur[0] > fe) {
                res.add(Arrays.asList(cur[0], cur[1]));
            }
            else if(cur[0] >= fs && cur[1] <= fe) continue;
            else if(fs > cur[0] && fe < cur[1]){
                res.add(Arrays.asList(cur[0], fs - 1));
                res.add(Arrays.asList(fe + 1, cur[1]));
            }
            else if(cur[0] < fs && cur[1] <= fe){
                cur[1] = Math.min(cur[1], fs - 1);
                res.add(Arrays.asList(cur[0], cur[1]));
            }else{
                cur[0] = Math.max(cur[0], fe + 1);
                res.add(Arrays.asList(cur[0], cur[1]));
            }
        }

        return res;
    }
}