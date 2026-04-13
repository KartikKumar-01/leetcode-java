class NumArray {
    int n;
    int[] st;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.st = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] a, int i, int l, int r){
        if(l == r){
            st[i] = a[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(a, 2 * i + 1, l, mid);
        build(a, 2 * i + 2, mid + 1, r);

        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }
    
    public void update(int index, int val) {
        update(index, val, 0, 0, n - 1);
    }
    private void update(int idx, int val, int i, int l, int r){
        if(l == r) {
            st[i] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if(idx <= mid){
            update(idx, val, 2 * i + 1, l, mid);
        }else {
            update(idx, val, 2 * i + 2, mid + 1, r);
        }

        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, 0, 0, n - 1);
    }
    private int query(int s, int e, int i, int l, int r){
        if(e < l || s > r) return 0;
        if(s <= l && r <= e){
            return st[i];
        }
        int mid = l + (r - l) / 2;
        return query(s, e, 2 * i + 1, l, mid) + query(s, e, 2 * i + 2, mid + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */