class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long res = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int val = matrix[i][j];
                res += Math.abs(val);
                if(val < 0)
                    count++;
                min = Math.min(min, Math.abs(val));
            }
        }
        if(count % 2 == 0){
            return res;
        }
        else{
            return res - 2 * min;
        }
    }
}