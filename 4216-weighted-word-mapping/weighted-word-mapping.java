class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(String w : words){
            for(char c : w.toCharArray()){
                sum += weights[(c - 'a')];
            }
            sb.append((char) ('z' - (sum % 26)));
            sum = 0;
        }
        return sb.toString();
    }
}