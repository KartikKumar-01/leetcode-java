class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int lm = height[left], rm = height[right];
        int ans = 0;
        while(left <= right){
            if(lm < rm){
                if(lm < height[left]) lm = height[left];
                else ans += lm - height[left];
                left++;
            }else{
                if(rm < height[right]) rm = height[right];
                else ans += rm - height[right];
                right--;
            }
        }
        return ans;
    }
}