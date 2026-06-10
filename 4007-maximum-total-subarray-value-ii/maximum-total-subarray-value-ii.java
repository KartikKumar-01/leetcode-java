class Solution {
    class Entity{
        long val;
        int r;
        int l;
        Entity(long val, int l, int r){
            this.val = val;
            this.r = r;
            this.l = l;
        }
    }
    int[] mxsg;
    int[] mnsg;
    int n;
    public long maxTotalValue(int[] nums, int k) {
        n = nums.length;
        mxsg = new int[4 * n];
        mnsg = new int[4 * n];
        build(mxsg, nums, 0, 0, n - 1, true);
        build(mnsg, nums, 0, 0, n - 1, false);
        PriorityQueue<Entity> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        
        long res = 0;
        for(int l = 0; l < n; l++){
            long val = getValue(l, n - 1);
            pq.add(new Entity(val, l, n - 1));
        }
        while(k--> 0){
            Entity e = pq.poll();
            res += e.val;
            if (e.l <= e.r - 1) {
                long nextBest = getValue(e.l, e.r - 1);
                pq.offer(new Entity(nextBest, e.l, e.r - 1));
            }
        }
        return res;

    }
    private long getValue(int l, int r){
        int mn = query(mnsg, 0, l, r, 0, n - 1, false);
        int mx = query(mxsg, 0, l, r, 0, n - 1, true);
        return (long) mx - mn;
    }
    private void build(int[] sg, int[] nums, int i, int l, int r, boolean max){
        if(l == r){
            sg[i] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(sg, nums, 2 * i + 1, l, mid, max);
        build(sg, nums, 2 * i + 2,  mid + 1, r, max);
        if(max)
            sg[i] = Math.max(sg[2 * i + 1], sg[2 * i + 2]);
        else 
            sg[i] = Math.min(sg[2 * i + 1], sg[2 * i + 2]);

    }
    private int query(int[] sg, int i, int start, int end, int left, int right, boolean max){
        if(end < left || start > right) return max ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        if(start <= left && right <= end) return sg[i];

        int mid = left + (right - left) / 2;
        int leftAns = query(sg, 2 * i + 1, start, end, left, mid, max);
        int rightAns = query(sg, 2 * i + 2, start, end, mid + 1, right, max);
        return max ? Math.max(leftAns, rightAns) : Math.min(leftAns, rightAns);
    }
}