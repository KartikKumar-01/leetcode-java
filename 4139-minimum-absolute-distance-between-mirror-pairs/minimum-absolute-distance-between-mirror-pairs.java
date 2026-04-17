class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int x = nums[i];
            StringBuilder rev = new StringBuilder(String.valueOf(x));
            rev.reverse();
            int r = Integer.parseInt(rev.toString().replaceFirst("^0+(?!$)", ""));
            if(map.containsKey(x)){
                int j = map.get(x);
                ans = Math.min(ans, Math.abs(i - j));
            }
            map.put(r, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}