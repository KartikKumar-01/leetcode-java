class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int o = 0;
        int e = 0;
        
        Arrays.sort(nums1);

        int mn = nums1[0];
        int x = mn % 2;
        if(x == 0) e++;
        else o++;

        for(int i = 1; i < n; i++){
            int t = nums1[i] % 2;
            if(x == 0 && t != 0){
                if(t == 0){
                    if(e == 0) return false;
                }else {
                    if(o == 0) return false;
                }
            }else if(x == 1 && t != 1){
                if(t == 0){
                    if(o == 0) return false;
                }else {
                    if(e == 0) return false;
                }
            }
            if(t == 0) e++;
            else o++;
        }
        // if (e == 0 || o == 0) return true;
        return true;
    }
}