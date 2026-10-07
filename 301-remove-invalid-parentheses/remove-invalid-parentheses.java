class Solution {
    HashMap<Integer, Set<String>> map = new HashMap<>();
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        helper(s, 0, 0, 0, new StringBuilder());
        int min = Integer.MAX_VALUE;
        for(int x : map.keySet()) min = Math.min(x, min);
        return min == Integer.MAX_VALUE ? new ArrayList<>() : new ArrayList<>(map.get(min));
    }
    private void helper(String s, int open, int close, int i, StringBuilder cur){
        if(i == s.length()){
            if(open == close){
                int deletions = s.length() - cur.length();
                map.computeIfAbsent(deletions, k -> new HashSet<>()).add(cur.toString());
            }
            return;
        }
        char c = s.charAt(i);
        if(Character.isLetter(c)){
            cur.append(c);
            helper(s, open, close, i + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }else if(c == '('){
            cur.append(c);
            helper(s, open + 1, close, i + 1, cur);
            cur.deleteCharAt(cur.length() - 1);

            helper(s, open, close, i + 1, cur);
        }else{
            if(open > close){
                cur.append(c);
                helper(s, open, close + 1, i + 1, cur);
                cur.deleteCharAt(cur.length() - 1);

            }
                helper(s, open, close, i + 1, cur);
        }
    }
}