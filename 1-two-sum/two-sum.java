class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // for(int i = 0; i < n; i++){
        //     int x = nums[i];
        //     for(int j = i + 1; j < n; j++){
        //         if(x + nums[j] == target) 
        //     }
        // }
        // return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int x = target - nums[i];
            if(map.containsKey(x)) return new int[]{map.get(x), i};
            else map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}