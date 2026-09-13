class Solution {
    Result[][] dp;
    class Result{
        long wt;
        List<Integer> idx;
        Result(long wt, List<Integer> idx){
            this.wt = wt;
            this.idx = idx;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> it = intervals.get(i);
            list.add(new int[]{it.get(0), it.get(1), it.get(2), i});
        }
        list.sort((x, y) -> {
            if(x[0] == y[0]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });
        dp = new Result[n + 1][5];
        Result res = helper(list, 0, 4);
        int[] ans = new int[res.idx.size()];
        for(int i = 0; i < res.idx.size(); i++){
            ans[i] = res.idx.get(i);
        }
        return ans;
    }
    private Result helper(List<int[]> a, int i, int r){
        int n = a.size();
        if(r == 0 || i == n) return new Result(0, new ArrayList<>());
        if(dp[i][r] != null) return dp[i][r];
        
        Result skip = helper(a, i + 1, r);

        int id = n;

        int low = i + 1, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(a.get(mid)[0] > a.get(i)[1]){
                id = mid;
                high = mid - 1;
            }else low = mid + 1;
        }

        Result rem = helper(a, id, r - 1);
        long tw = a.get(i)[2] + rem.wt;
        List<Integer> idx = new ArrayList<>(rem.idx);
        idx.add(a.get(i)[3]);
        Collections.sort(idx);

        Result take = new Result(tw, idx);
        Result best = better(skip, take);
        return dp[i][r] =  best;
    }
    private Result better(Result a, Result b) {

        if (a.wt != b.wt) {
            return a.wt > b.wt ? a : b;
        }

        return compare(a.idx, b.idx) <= 0 ? a : b;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}