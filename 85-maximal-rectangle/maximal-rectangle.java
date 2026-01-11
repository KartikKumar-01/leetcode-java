class Solution {
    private int largestRectangleArea(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        right[n - 1] = n;

        for(int i = 1; i < n; i++){
            int prev = i - 1;
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = left[prev];
            }
            left[i] = prev;
        }
        for(int i = n - 2; i >= 0; i--){
            int next = i + 1;
            while(next < n && heights[next] >= heights[i]){
                next = right[next];
            }
            right[i] = next;
        }
        int area = 0;
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            int h = heights[i];
            area = Math.max(area, width * h);
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int heights[] = new int[m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }
                else{
                    heights[j]++;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }
}