class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;

        int[] smaller = new int[len];
        int[] greater = new int[len];
        int i = 0, j = 0;
        int pCount = 0;
        for(int num : nums){
            if(num < pivot){
                smaller[i++] = num;
            }
            else if(num > pivot){
                greater[j++] = num;
            }
            else{
                pCount++;
            }
        }
        int[] res = new int[len];
        int x = 0; int y = 0;
        while(x < i){
            res[x++] = smaller[y++];
        }
        while(pCount > 0){
            res[x++] = pivot;
            pCount--;
        }
        y = 0;
        while(y < j){
            res[x++] = greater[y++];
        }
        return res;
    }
}