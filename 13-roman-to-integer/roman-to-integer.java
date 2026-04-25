class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = map.get(s.charAt(n - 1));
        for(int i = n - 2; i >= 0; i--){
            char cur = s.charAt(i);
            char prev = s.charAt(i + 1);
            int cv = map.get(cur);
            int pv = map.get(prev);
            if(cv < pv){
                ans -= cv;
            }else ans += cv;
        }
        return ans;
    }
}