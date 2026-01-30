class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int len = 1;
        int left = 0;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.get(c) > 1){
                char t = s.charAt(left);
                map.put(t, map.get(t) - 1);
                if(map.get(t) == 0){
                    map.remove(t);
                }
                left++;
            }
            len = Math.max(len, i - left + 1);
        }
        return len;
    }
}