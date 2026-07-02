class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        boolean wordEnd;
        TrieNode(){
            word = "";
            wordEnd = false;
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = this.root;
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(cur.children[idx] == null){
                    cur.children[idx] = new TrieNode(); 
                }
                cur = cur.children[idx];
            }
            cur.wordEnd = true;
            cur.word = word;
        }
    }
    int n;
    int m;
    List<String> res;
    int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        this.n = board.length;
        this.m = board[0].length;
        res = new ArrayList<>();

        Trie trie = new Trie();
        for(String word : words) trie.insert(word);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char c = board[i][j];
                if(trie.root.children[c - 'a'] != null){
                    dfs(board, i, j, trie.root);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] board, int i, int j, TrieNode node){
        char ch = board[i][j];
        if(ch == '$') return;

        node = node.children[ch - 'a'];
        if(node == null) return;

        if(node.wordEnd){
            res.add(node.word);
            node.wordEnd = false;
        }

        board[i][j] = '$';

        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && r < n && c >= 0 && c < m && board[r][c] != '$'){
                dfs(board, r, c, node);
            }
        }
        board[i][j] = ch;
    }
}