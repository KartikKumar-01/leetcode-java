class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int b = arr2.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr1){
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }
        int ans = 0;
        for(int num : arr2){
            int count = len(num);
            while(num > 0){
                if(set.contains(num)){
                    ans = Math.max(ans, count);
                }
                count--;
                num /= 10;
            }
        }
        return ans;
    }
    int len(int n){
        int l = 0;
        while(n > 0){
            l++;
            n /= 10;
        }
        return l;
    }
}