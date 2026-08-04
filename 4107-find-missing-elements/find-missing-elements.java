class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int i = nums[0]; i < nums[nums.length - 1]; i++){
            if(!set.contains(i)) res.add(i);
        }
        return res;
    }
}