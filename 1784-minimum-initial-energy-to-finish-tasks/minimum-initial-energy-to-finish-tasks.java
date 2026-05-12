class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> Integer.compare((b[1] - b[0]),(a[1] - a[0])));
        int low = 0, high = (int)10e9;
        int ans = -1;
        // for(int[] task : tasks)
        //     System.out.println(Arrays.toString(task));
        while(low <= high){
            int mid = low + (high - low ) / 2;
            if(possible(tasks, mid)){
                ans = mid;
                // System.out.println(ans);
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    private boolean possible(int[][] a, int t){
        for(int[] x : a){
            int min = x[1];
            int loss = x[0];
            if(t < min) return false;
            t -= loss;
        }
        return true;
    }
}