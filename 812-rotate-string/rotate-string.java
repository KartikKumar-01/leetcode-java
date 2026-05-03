class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        return (n == m) &&  (s+s).indexOf(goal) != -1;
    }
}