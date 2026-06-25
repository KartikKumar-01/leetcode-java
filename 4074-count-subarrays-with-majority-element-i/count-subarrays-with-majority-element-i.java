class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int freq = 0;
            for(int j = i; j < n; j++){
                // int maj = findMaj(nums, i, j);
                // if(maj == target) count++;
                if(nums[j] == target) freq++;
                else freq--;
            if(freq >= 1) count++;
            }
        }
        return count;
    }
    private int findMaj(int[] nums, int s, int e){
        int n = (e - s + 1) / 2;
        int maj = -1;
        int count = 0;
        for(int i = s; i < e; i++){
            if(count == 0){
                // count = 1;
                maj = nums[i];
            }
            if(nums[i] == maj) count++;
            else count--;
        }
        if(count > n / 2) return maj;
        return -1;
    }
}