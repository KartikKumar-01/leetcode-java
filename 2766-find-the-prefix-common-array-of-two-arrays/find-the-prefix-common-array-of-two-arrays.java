class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            if(A[i] == B[i]){
                res[i] += (i - 1 >= 0) ? 1 + res[i - 1] : 1;
            }else{
                res[i] += (i - 1 >= 0) ? res[i - 1] : 0;
                if(map.get(A[i]) == 2) res[i] += 1;
                if(map.get(B[i]) == 2) res[i] += 1;
            }
        }
        return res;
    }
}