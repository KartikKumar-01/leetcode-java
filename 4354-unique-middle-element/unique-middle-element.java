class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.get(nums[n / 2]) == 1;
    }
}