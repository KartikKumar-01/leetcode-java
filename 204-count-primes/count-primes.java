class Solution {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        int[] p = new int[n];
        Arrays.fill(p, 1);
        p[0] = 0;
        p[1] = 0;
        
        for(int i = 2; i * i < n; i++){
            if(p[i] == 1){
                for(int j = i * i; j < n; j += i){
                    p[j] = 0;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) if(p[i] == 1) count++;
        return count;
    }
}