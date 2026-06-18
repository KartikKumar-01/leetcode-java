class Solution {
    public double angleClock(int hour, int minutes) {
        double val = Math.abs(30 * hour - 5.5 * minutes);
        return Math.min(val, 360 - val);
    }
}