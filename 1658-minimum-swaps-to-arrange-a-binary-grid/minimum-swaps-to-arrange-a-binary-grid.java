class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 0){
                    count++;
                }
                else break;
            }
                    a[i] = count;
        }
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int nd = n - i - 1;
            int j = i;
            
            while(j < n && a[j] < nd){
                j++;
            }
            if(j == n) return -1;

            while(j > i){
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                ans++;
                j--;
            }
        }
        return ans;
    }
}