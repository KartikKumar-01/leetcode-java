class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>(); // stores the curr free rooms available
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> { // stores busy rooms as pair of end time and the room no.
            if(a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for(int i = 0; i < n; i++) free.offer(i);

        int[] count = new int[n];

        for(int[] meeting: meetings){
            int start = meeting[0];
            int duration = meeting[1] - start;

            while(!busy.isEmpty() && busy.peek()[0] <= start){
                free.offer((int)busy.poll()[1]);
            }

            if(!free.isEmpty()){
                int room = free.poll();
                count[room]++;
                busy.offer(new long[]{meeting[1], room});
            }
            else{
                long[] temp = busy.poll();
                busy.offer(new long[]{temp[0] + duration, temp[1]});
                count[(int) temp[1]]++;
            }
        }
        int ans = 0;
        for(int i = 1; i < n; i++){
            if(count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}