class Solution {
    class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(arr, 2 * node + 1, l, mid);
        build(arr, 2 * node + 2, mid + 1, r);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    
    public int query(int left, int right) {
        return query(left, right, 0, 0, n - 1);
    }

    private int query(int left, int right, int node, int l, int r) {
        // No overlap
        if (r < left || l > right)
            return Integer.MIN_VALUE;

        // Complete overlap
        if (left <= l && r <= right)
            return tree[node];

        // Partial overlap
        int mid = l + (r - l) / 2;

        return Math.max(
                query(left, right, 2 * node + 1, l, mid),
                query(left, right, 2 * node + 2, mid + 1, r)
        );
    }
}

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int cnt = 0;
        for(char c : s.toCharArray()) if(c == '1') cnt++;

        List<Integer> blkStart = new ArrayList<>();
        List<Integer> blkEnd = new ArrayList<>();

        int j = 0;
        while(j < n){
            if(s.charAt(j) == '0'){
                blkStart.add(j);
                while(j < n && s.charAt(j) == '0') j++;
                blkEnd.add(j - 1);
            }else j++;
        }

        int q = queries.length;

        int m = blkStart.size();
        if(m <= 1) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < q; i++) res.add(cnt);
            return res;
        }

        List<Integer> res = new ArrayList<>();
        int[] blkSize = new int[m];
        for(int i = 0; i < m; i++){
            blkSize[i] = blkEnd.get(i) - blkStart.get(i) + 1;
        }

        int N = m - 1;
        int[] pairsum = new int[N];
        for(int i = 0;i < N; i++){
            pairsum[i] = blkSize[i] + blkSize[i + 1];
        }

        SegmentTree sg = new SegmentTree(pairsum);


        for(int[] qr : queries){
            int l = qr[0];
            int r = qr[1];

            int low = lb(blkEnd, l);
            int high = ub(blkStart, r) - 1;
            int mx = 0;
            if(low < high){
                int fl = blkEnd.get(low) - Math.max(blkStart.get(low), l) + 1;
                int ll = Math.min(blkEnd.get(high), r) - blkStart.get(high) + 1;

                if(high -low == 1){
                    mx = fl + ll;
                }else{
                    int pair1 = fl + blkSize[low + 1];
                    int pair2 = blkSize[high - 1] + ll;
                    int rmq = sg.query(low + 1, high - 2);
                    mx = Math.max(pair1, Math.max(pair2, rmq));
                }
            }
            res.add(cnt + mx);
        }
        // List<Integer> res = new ArrayList<>();
        return res;
    }

    int lb(List<Integer> arr, int x) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) < x)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
    int ub(List<Integer> arr, int x) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) <= x)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}