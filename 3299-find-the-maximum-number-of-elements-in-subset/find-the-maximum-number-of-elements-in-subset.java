class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        int ans = map.getOrDefault(1, 0);
        if(ans % 2 == 0) ans = Math.max(0, --ans);
        map.remove(1);

        for(int x : map.keySet()){
            int sq = (int) Math.sqrt(x);
            if(sq * sq == x && map.getOrDefault(sq, 0) > 1) continue;

            int n = 0;
            int val = x;
            while(val < 31622 && map.containsKey(val) && map.get(val) > 1){
                n += 2;
                val *= val;
            }
            ans = Math.max(ans, n + (map.containsKey(val) ? 1 : -1));
        }
        return ans % 2 == 0 ? ans - 1 : ans;
    }
}