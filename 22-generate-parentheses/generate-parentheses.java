class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, "", 0, 0);
        return res;
    }
    private void dfs(int n, List<String> res, String curr, int open, int close){
        if(open == close && open + close == 2 * n){
            res.add(curr);
            return;
        }
        if(open < n){
            dfs(n, res, curr + "(", open + 1, close);
        }
        if(close < open){
            dfs(n, res, curr + ")", open, close + 1);
        }
    }
}