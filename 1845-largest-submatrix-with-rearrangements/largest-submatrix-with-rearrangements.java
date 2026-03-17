class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Integer[] a = new Integer[m];
        Arrays.fill(a, 0);
        int ans = 0;
        for (int[] ints : matrix) {
            Integer[] b = new Integer[m];
            for (int j = 0; j < m; j++) {
                if (ints[j] == 0) a[j] = 0;
                else a[j] = a[j] + 1;
            }
            for(int j = 0; j < m; j++) b[j] = a[j];
            Arrays.sort(b, Comparator.reverseOrder());
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, b[j] * (j + 1));
            }
        }
        return ans;
    }
}