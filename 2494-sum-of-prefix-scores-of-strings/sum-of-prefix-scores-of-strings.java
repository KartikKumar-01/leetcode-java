class Solution {
    class TrieNode{
        int counter;
        TrieNode[] children;
        TrieNode(){
            counter = 0;
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        void insert(String s){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                int idx = c - 'a';
                if(cur.children[idx] == null) cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
                cur.counter++;
            }
        }
        int getCount(String s){
            TrieNode cur = root;
            int ans = 0;
            for(char c : s.toCharArray()){
                int idx = c - 'a';
                cur = cur.children[idx];
                ans += cur.counter;
            }
            return ans;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }

        int[] res = new int[words.length];
        for(int i = 0; i < words.length; i++){
            res[i] = trie.getCount(words[i]);
        }
        return res;
    }
}