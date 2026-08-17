class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int md = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < drones.length; i++){
            int x = drones[i][0], y = drones[i][1];
            int dist = dist(x, y, target[0], target[1]);
            if(dist <= drones[i][2]){
                if(dist < md){
                    ans = i;
                    md = dist;
                }
            }
        }

        return ans;
    }
    private int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y2 - y1);
    }
}