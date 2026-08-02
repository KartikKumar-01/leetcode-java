class Solution {
    public int maximumWidth(int[] planks) {
        int n = planks.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        HashMap<Integer, Integer> res = new HashMap<>();

        for(int x : planks){
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            res.put(x, res.getOrDefault(x, 0) + 1);
        }
        for(int a : cnt.keySet()){
            for(int b : cnt.keySet()){
                if(a < b){
                    res.put(a + b, res.getOrDefault(a + b, 0) + Math.min(cnt.get(a) , cnt.get(b))); 
                }
                if(a == b){
                    res.put(a + b, res.getOrDefault(a + b, 0) + cnt.get(a) / 2);
                }
            }
        }
        int ans = 0;
        for(int x : res.values()) ans = Math.max(ans, x);
        return ans;
    }
}