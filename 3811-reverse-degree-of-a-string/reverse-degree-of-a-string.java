class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int idx = 26 - (s.charAt(i) - 'a');
            sum += (i + 1) * idx;
        }
        return sum;
    }
}