class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] ans = new char[m][n];
        for(int i = 0; i< n; i++){
            Queue<Integer> q = new LinkedList<>();
            for(int j = m - 1; j >= 0; j--){
                if(boxGrid[i][j] == '*') q.clear();
                else if (boxGrid[i][j] == '.') q.offer(j);
                else if(!q.isEmpty()) {
                    int empty = q.poll();
                    boxGrid[i][empty] = '#';
                    boxGrid[i][j] = '.';
                    q.offer(j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) ans[j][i] = boxGrid[i][j];
        }
        for(char[] c : ans){
            int i = 0;
            int j = n - 1;
            while(i <= j){
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        // for(char[] x : boxGrid) System.out.println(Arrays.toString(x));
        return ans;
    }
}