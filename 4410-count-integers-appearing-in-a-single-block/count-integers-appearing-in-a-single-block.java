class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int prev = nums[0];
        for(int j = 1; j < n; j++){
            if(nums[j] != prev){
                map.computeIfAbsent(prev, k -> new ArrayList<>());
                map.get(prev).add(new int[]{i, j});
                i = j;
            }
            prev = nums[j];
        }
        map.computeIfAbsent(prev, k -> new ArrayList<>());
        map.get(prev).add(new int[]{i, n - 1});
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key).size() == 1) ans++;
        }
        return ans;
    }
}