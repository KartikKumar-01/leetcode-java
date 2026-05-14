class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            if(x >= n || x < 1) return false;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        System.out.println(map.toString());
        return map.size() == (n - 1) && map.containsKey(n - 1) && map.get(n - 1) == 2;
    }
}