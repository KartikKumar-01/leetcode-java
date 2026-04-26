class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int req = m;
        int len = Integer.MAX_VALUE;
        int start = -1;
        for(int right = 0; right < n; right++){
            char r = s.charAt(right);
            if(map.containsKey(r)){
                if(map.get(r) > 0){
                    req--;
                }
                map.put(r, map.get(r) - 1);
            }

            while(req == 0){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    start = left;
                }
                char l = s.charAt(left);
                if(map.containsKey(l)){
                    map.put(l, map.get(l) + 1);
                    if(map.get(l) > 0){
                        req++;
                    }
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + len);
    }
}