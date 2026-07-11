class Solution {
    class TrieNode{
        int num;
        TrieNode[] children;
        TrieNode(){
            num = -1;
            children = new TrieNode[2];
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        void insert(int num){
            TrieNode cur = root;
            for(int i = 31; i >= 0; i--){
                int bit = (num >> i) & 1;
                if(cur.children[bit] == null) cur.children[bit] = new TrieNode();
                cur = cur.children[bit];
            }
            cur.num = num;
        }
        int getMax(int num){
            TrieNode cur = root;
            
            for(int i = 31; i >= 0; i--){
                int curBit = (num >> i) & 1;
                int oppBit = curBit ^ 1;
                if(cur.children[oppBit] != null){
                    cur = cur.children[oppBit];
                }else if(cur.children[curBit] != null){
                    cur = cur.children[curBit];
                }else return -1;
            }
            return cur.num;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num : nums){
            trie.insert(num);
        }

        int ans = 0;
        for(int num : nums){
            int max = trie.getMax(num);
            if(max != -1){
                ans = Math.max(ans, max ^ num);
            }
        }
        return ans;
    }
}