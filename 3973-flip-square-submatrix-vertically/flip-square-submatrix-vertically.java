class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Stack<ArrayList<Integer>> st = new Stack<>();
        for(int i = x; i < x + k; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = y; j < y + k; j++){
                temp.add(grid[i][j]);
            }
            st.push(temp);
        }

        while(!st.isEmpty()){
            for(int i = x; i < x + k; i++){
                ArrayList<Integer> temp = st.pop();
                int a = 0;
                for(int j = y; j < y + k; j++){
                    grid[i][j] = temp.get(a++);
                }
            }
        }
        return grid;
    }
}