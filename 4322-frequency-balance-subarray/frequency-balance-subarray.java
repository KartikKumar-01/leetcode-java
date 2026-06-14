class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            HashMap<Integer, Integer> freq = new HashMap<>();
            HashMap<Integer, Integer> oldFreq = new HashMap<>();
            int j;
            for(j = i; j < n; j++){

                int old = freq.getOrDefault(nums[j], 0);
                if(old > 0) {
                    oldFreq.put(old, oldFreq.get(old) - 1);
                    if(oldFreq.get(old) == 0) oldFreq.remove(old);
                }

                int nFreq = old + 1;
                freq.put(nums[j], nFreq);
                oldFreq.put(nFreq, oldFreq.getOrDefault(nFreq, 0) + 1);
            
                if(freq.size() == 1) ans = Math.max(ans, j - i + 1);
                else if(oldFreq.size() == 2){
                    Iterator<Integer> it = oldFreq.keySet().iterator();
                    int f = it.next();
                    int s = it.next();
                    int mn = Math.min(f, s);
                    int mx = Math.max(f, s);
                    if(mx == 2 * mn) ans = Math.max(ans, j - i + 1);
                }
                
            }
        }
        return ans;
    }
}