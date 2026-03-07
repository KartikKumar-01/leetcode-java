class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int i;
        HashSet<Integer> set = new HashSet<>();
        for(i = n - 1; i >= 0; i--){
            if(set.contains(nums[i])) break;
            set.add(nums[i]);
        }
        return Math.ceilDiv(i + 1, 3);
    }
}