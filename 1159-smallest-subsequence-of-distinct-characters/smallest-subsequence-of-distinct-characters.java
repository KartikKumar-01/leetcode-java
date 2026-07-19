class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        int n = s.length();
        Stack<Character> st = new Stack<>();
        boolean[] seen = new boolean[26];

        for(char c : s.toCharArray()) freq[c - 'a']++;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            int idx = c - 'a';
            freq[idx]--;
            if(seen[idx]) continue;

            while(!st.isEmpty() && st.peek() > c && freq[st.peek() - 'a'] >= 1){
                seen[st.pop() - 'a'] = false;
            }
            st.push(c);
            seen[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st) sb.append(c);
        return sb.toString();
    }
}