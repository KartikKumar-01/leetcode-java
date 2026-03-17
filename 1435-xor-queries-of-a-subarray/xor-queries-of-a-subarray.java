class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] a = new int[n + 1];
        for(int i = 1; i <= n; i++){
            a[i] = a[i - 1] ^ arr[i - 1];
        }
        System.out.println(Arrays.toString(a));
        int[] b = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            b[i] = a[r + 1] ^ a[l];
        }
        return b;
    }
}