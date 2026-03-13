class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(capacity[i] >= itemSize && capacity[i] < ans){
                ans = capacity[i];
                idx = i;
            }
        }
        return idx;
    }
}