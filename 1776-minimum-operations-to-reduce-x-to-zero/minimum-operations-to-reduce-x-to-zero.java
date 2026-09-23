class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int tar = -x;
        for(int num : nums) tar += num;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mx = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(map.containsKey(sum - tar)){
                int j = map.get(sum - tar);
                mx = Math.max(mx, i - j);
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return mx == 0 && tar != 0 ? -1 : n - mx;
    }
}