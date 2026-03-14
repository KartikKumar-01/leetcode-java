class Solution {

    ArrayList<String> list = new ArrayList<>();
    char[] ch = {'a','b','c'};

    public String getHappyString(int n, int k) {

        int block = 1 << (n-1);
        int total = 3 * block;

        if(k > total) return "";

        int charType = (k-1) / block;

        char first = ch[charType];

        k = (k-1) % block + 1;

        StringBuilder sb = new StringBuilder();
        sb.append(first);

        solve(n, first, sb);

        return list.get(k-1);
    }

    private void solve(int n, char last, StringBuilder cur){

        if(cur.length() == n){
            list.add(cur.toString());
            return;
        }

        for(char c : ch){
            if(c != last){
                cur.append(c);
                solve(n, c, cur);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }
}