class Solution {
    int[] sg;

    void update(int idx, int val, int i, int l, int r){
        if(l == r){
            sg[i] = val;
            return ;
        }
        int mid = l + (r - l) / 2;
        
        if(idx <= mid){
            update(idx, val, 2 * i + 1, l, mid);
        }else{
            update(idx, val, 2 * i + 2, mid + 1, r);
        }
        sg[i] = Math.max(sg[2 * i + 1], sg[2 * i + 2]);
    }

    int query(int st, int end, int i, int l, int r){
        if(st > r || end < l) return 0;

        if(l >= st && r <= end) return sg[i];

        int mid = l + (r - l) / 2;
        
        return Math.max(query(st, end, 2 * i + 1, l, mid), query(st, end, 2 * i + 2, mid + 1, r));
    }

    public List<Boolean> getResults(int[][] queries) {
        int n = 50001;
        TreeSet<Integer> set = new TreeSet<>();
        sg = new int[n * 4];

        set.add(0);
        set.add(n);
        update(n, n, 0, 0, n);


        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            int t = q[0];
            if(t == 1){
                int x = q[1];
                int next = Optional.ofNullable(set.ceiling(x + 1)).orElse(n);
                int prev = Optional.ofNullable(set.floor(x - 1)).orElse(0);
                update(x, x - prev, 0, 0, n);
                update(next, next - x, 0, 0, n);
                set.add(x);
            }else{
                int x = q[1];
                int sz = q[2];
                int prev = Optional.ofNullable(set.floor(x)).orElse(0);
                int max = query(0, prev, 0, 0, n);
                max = Math.max(max, x - prev);
                ans.add(max >= sz);
            }
        }
        return ans;
    }
}