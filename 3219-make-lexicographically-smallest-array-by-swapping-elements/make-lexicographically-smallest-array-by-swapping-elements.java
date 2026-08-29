class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) list.add(new int[]{nums[i], i});
        Collections.sort(list, (x, y) -> {
            if(x[0] == y[0]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        for(int[] x : list) System.out.println(Arrays.toString(x));
        List<int[]> comps = new ArrayList<>();
        int i = 0;
        int prev = list.get(0)[0];
        for(int j = 1; j < n; j++){
            int cur = list.get(j)[0];
            if(cur - prev > limit && j - i + 1 > 1){
                comps.add(new int[]{i, j - 1});
                i = j;
            }
            prev = cur;
        }
        if(n - i > 1) comps.add(new int[]{i, n - 1});
        for(int[] x : comps) System.out.println(Arrays.toString(x));

        for(int[] comp : comps){
            int u = comp[0], v = comp[1];
            List<Integer> idx = new ArrayList<>();
            for(int k = u; k <= v; k++){
                idx.add(list.get(k)[1]);
            }
            Collections.sort(idx);
            for(int k = u; k <= v; k++){
                nums[idx.get(k - u)] = list.get(k)[0];
            }
        }
        return nums;
    }
}