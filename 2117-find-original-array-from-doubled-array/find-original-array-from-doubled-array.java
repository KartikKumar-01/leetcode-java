class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0) return new int[0];
        int[] ans = new int[n / 2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : changed) map.put(x, map.getOrDefault(x, 0) + 1);
        if(map.getOrDefault(0, 0) % 2 != 0)
            return new int[0];
        Arrays.sort(changed);
        int i = 0;
        for(int x : changed){
            if(map.get(x) == 0) continue;
            if(!map.containsKey(x * 2) || map.get(x * 2) == 0){
                return new int[0];
            }
            ans[i++] = x;
            map.put(x, map.get(x) - 1);
            map.put(x * 2, map.get(x * 2) - 1);
        }
        return ans;
    }
}