class TreeAncestor {
    int[][] up;
    int col;
    public TreeAncestor(int n, int[] parent) {
        col = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[n][col];
        for(int[] u : up) Arrays.fill(u, -1);
        for(int node = 0; node < n; node++) up[node][0] = parent[node];

        for(int j = 1; j < col; j++){
            for(int node = 0; node < n; node++){
                if(up[node][j - 1] == -1) continue;
                up[node][j] = up[up[node][j - 1]][j - 1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int b = 0; b < col; b++){
            if((k & (1 << b)) != 0){
                node = up[node][b];
                if(node == -1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */