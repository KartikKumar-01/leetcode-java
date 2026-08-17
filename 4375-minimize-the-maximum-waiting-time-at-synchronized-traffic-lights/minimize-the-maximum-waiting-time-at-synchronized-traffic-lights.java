class Solution {
    public int minPenalty(int pd, int[] lt, int[] at) {
        int n = at.length;
        int m = lt.length;

        for(int i = 0; i < n; i++) at[i] %= pd;
        Arrays.sort(at);
        int mx = Arrays.stream(lt).max().getAsInt();
        for(int i = 0; i < n; i++){
            if(at[i] >= mx){
                return pd - at[i];
            }
        }
        return 0;
    }
}