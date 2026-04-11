class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n < 3) return -1;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = map.computeIfAbsent(nums[i], k -> new ArrayList<>());
            list.add(i);
            if(list.size() >= 3){
                int size = list.size();
                int a = list.get(size - 3);
                int b = list.get(size - 1);
                ans = Math.min(ans, 2 * (b - a));
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}