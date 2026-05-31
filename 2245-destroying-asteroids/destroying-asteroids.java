class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        Arrays.sort(asteroids);
        long m = mass;
        for(int x : asteroids){
            if(m < x) return false;
            m += (long)x;
        }
        return true;
    }
}