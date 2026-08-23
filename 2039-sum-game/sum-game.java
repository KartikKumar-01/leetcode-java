class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int lQnMark = 0;
        int rQnMark = 0;
        int lSum = 0;
        int rSum = 0;

        for(int i = 0; i < n; i++){
            if(num.charAt(i) == '?'){
                if(i < n / 2) lQnMark++;
                else rQnMark++;
            }else{
                if(i < n / 2) lSum += num.charAt(i) - '0';
                else rSum += num.charAt(i) - '0';
            }
        }
        int total = lQnMark + rQnMark;
        int left = 2 * lSum + 9 * lQnMark;
        int right = 2 * rSum + 9 * rQnMark;
        return left != right;
    }
}