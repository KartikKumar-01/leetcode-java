class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n < 3) return -1;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
            if(list.size() >= 3){
                int min = Integer.MAX_VALUE;
                for(int j = 0; j + 2 < list.size(); j++){
                    min = Math.min(min, list.get(j + 2) - list.get(j));
                }
                ans = Math.min(ans, 2 * min);
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}