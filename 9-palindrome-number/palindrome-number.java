class Solution {
    public boolean isPalindrome(int x) {
        char[] str = String.valueOf(x).toCharArray();
        int i = 0, j = str.length - 1;
        while(i <= j){
            if(str[i] != str[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}