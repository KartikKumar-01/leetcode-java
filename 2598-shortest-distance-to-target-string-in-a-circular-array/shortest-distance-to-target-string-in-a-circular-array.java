class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <  n;i++){
            if(words[i % n].equals(target)){
                int min = Math.min(Math.abs(i - startIndex), n - Math.abs(i - startIndex));
                ans = Math.min(ans, min);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}