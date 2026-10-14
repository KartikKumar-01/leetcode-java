class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum < 1 || sum > 9 * num) return "";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++) sb.append("0");
        for(int i = 0; i < num; i++){
            if(sum <= 9){
                sb.setCharAt(i, (char) ('0' + sum));
                break;
            }
            else{
                sb.setCharAt(i, '9');
                sum -= 9;
            }
        }
        return sb.toString();
    }
}