class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int j = 0; j < n; j++){
            int x = nums.get(j);
                ans[j] = -1;
            for(int i = 0; i < x; i++){
                if((i | (i + 1)) == x){
                    ans[j] = i;
                    break;
                }
            }
        }
        return ans;
    }
}