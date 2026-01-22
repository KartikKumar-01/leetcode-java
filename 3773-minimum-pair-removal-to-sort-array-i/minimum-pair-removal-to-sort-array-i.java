class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        for(int x : nums){
            list.add(x);
        }
        int count = 0;
        while(true){
            boolean sorted = true;
            for(int i = 0; i < list.size() - 1; i++){
                if(list.get(i) > list.get(i + 1)) {
                    sorted = false;
                    break;
                }
            }
            if(sorted) break;
            int mins = Integer.MAX_VALUE;
            int idx = -1;
            for(int i = 0; i < list.size() - 1; i++){
                int sum = list.get(i) + list.get(i + 1);
                if(mins > sum){
                    mins = sum;
                    idx = i;
                }
            }
            if(idx != -1){
                list.remove(idx);
                list.remove(idx);
                list.add(idx, mins);
            }
            count++;
        }
        return count;
    }
}