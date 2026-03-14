class Solution {
    ArrayList<String> list = new ArrayList<>();
    char[] ch = {'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        solve(n, '#', new StringBuilder());
        Collections.sort(list);
        if(k > list.size()) return "";
        return list.get(k - 1);
    }
    private void solve(int n, char last, StringBuilder cur){
        if(cur.length() == n) {
            list.add(cur.toString());
            return;
        }
        for(char c : ch){
            if(c != last){
                cur.append(c);
                solve(n, c, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}