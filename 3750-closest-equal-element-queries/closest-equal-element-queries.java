class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int  n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int q = queries[i];
            List<Integer> cur = map.getOrDefault(nums[q], new ArrayList<>());
            if(cur.size() <= 1) {
                list.add(-1);
                continue;
            }
            int idx = find(cur, q);
            // if(idx == 0){
            //     int x = Math.min(cur.get(idx + 1) - cur.get(idx), n - (cur.get(cur.size() - 1) - cur.get(idx)));
            //     list.add(x);
            // }else if(idx == cur.size() - 1){
            //     int x = Math.min(cur.get(idx) - cur.get(idx - 1), n - (cur.get(idx) - cur.get(0)));
            //     list.add(x);
            // }else{
            //     list.add(Math.min(cur.get(idx) - cur.get(idx - 1), cur.get(idx + 1) - cur.get(idx)));
            // }
            int size = cur.size();
            int right = cur.get((idx + 1) % size);
            int d1 = Math.abs(right - q);
            int cd1 = n - d1;
            int x = Math.min(d1, cd1);
            int left = cur.get((idx - 1 + size) % size);
            int d2 = Math.abs(left - q);
            int cd2 = n - d2;
            x = Math.min(x, Math.min(cd2, d2));
            list.add(x);
        }
        return list;
    }
    private int find(List<Integer> cur, int q){
        int ans = -1;
        int low = 0, high = cur.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(cur.get(mid) == q){
                return mid;
            }else if(cur.get(mid) < q){
                low = mid + 1;
            }else high = mid - 1;
        }
        return ans;
    }
}