class Solution {
    class TrieNode{
        int bestLen;
        int bestIdx;
        boolean wordEnd;
        TrieNode[] children;
        TrieNode(int l, int i){
            bestLen = l;
            bestIdx = i;
            wordEnd = false;
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode(-1, -1);
        }

        public void insert(String s, int id){
            TrieNode cur = root;
            if(cur.bestLen == -1 || cur.bestLen > s.length() || (cur.bestLen == s.length() && cur.bestIdx > id)){
                    cur.bestLen = s.length();
                    cur.bestIdx = id;
                }

            for(int i = s.length() - 1; i >= 0; i--){
                char c = s.charAt(i);
                int idx = c - 'a';
                if(cur.children[idx] == null) cur.children[idx] = new TrieNode(s.length(), id);
                cur = cur.children[idx];
                if(cur.bestLen == -1 || cur.bestLen > s.length() || (cur.bestLen == s.length() && cur.bestIdx > id)){
                    cur.bestLen = s.length();
                    cur.bestIdx = id;
                }
            }
        }
        public int query(String s){
            TrieNode cur = root;
            int ans = root.bestIdx;
            for(int i = s.length() - 1; i >= 0; i--){
                char c = s.charAt(i);
                int idx = c - 'a';
                
                if(cur.children[idx] == null) break;
                cur = cur.children[idx];
                ans = cur.bestIdx;
            }
            return ans;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();
        int n = wordsContainer.length;
        for(int i = 0; i < n; i++){
            trie.insert(wordsContainer[i], i);
        }

        int q = wordsQuery.length;
        int[] ans = new int[q];

        for(int i = 0; i < q; i++){
            ans[i] = trie.query(wordsQuery[i]);
        }
        return ans;
    }
}