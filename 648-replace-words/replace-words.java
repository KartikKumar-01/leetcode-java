class Solution {
    class TrieNode{
        boolean wordEnd;
        String word;
        TrieNode[] children;
        TrieNode(){
            wordEnd = false;
            word = null;
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
            }
            cur.wordEnd = true;
            cur.word = s;
        }
        String getRoot(String s){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                int idx = c - 'a';
                if(cur.children[idx] == null) break;
                cur = cur.children[idx];
                if(cur.wordEnd) break;
            }
            return cur.wordEnd ? cur.word : null;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }

        StringBuilder sb = new StringBuilder();
        for(String s : sentence.split(" ")){
            String root = trie.getRoot(s);
            if(root == null) sb.append(s + " ");
            else sb.append(root + " ");
        }
        return sb.toString().trim();
    }
}