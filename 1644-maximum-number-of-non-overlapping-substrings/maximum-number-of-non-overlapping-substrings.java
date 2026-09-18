class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        int[] end = new int[26];
        boolean[] valid = new boolean[26];
        Arrays.fill(valid, true);
        Arrays.fill(start, -1);
        for(int i = 0; i < n; i++){
            int c = s.charAt(i) - 'a';
            if(start[c] == -1){
                start[c] = i;
            }
            end[c] = i;
        }

        for(int c = 0; c < 26; c++){
            if(start[c] == -1) continue;
            for(int i = start[c]; i <= end[c]; i++){
                if(start[s.charAt(i) - 'a'] < start[c]){
                    valid[c] = false;
                    break;
                }
                end[c] = Math.max(end[c], end[s.charAt(i) - 'a']);
            }
        }

        List<String> res = new ArrayList<>();
        int pi = n;

        for(int i = n - 1; i >= 0; i--){
            int c = s.charAt(i) - 'a';
            if(!valid[c]) continue;
            if(i == start[c] && end[c] < pi){
                res.add(s.substring(i, end[c] + 1));
                pi = i;
            }
        }
        return res;
    }
}