class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a = s1.charAt(0) < s1.charAt(2) ? new char[]{s1.charAt(0), s1.charAt(2)} : new char[]{s1.charAt(2), s1.charAt(0)};
        char[] b = s1.charAt(1) < s1.charAt(3) ? new char[]{s1.charAt(1), s1.charAt(3)} : new char[]{s1.charAt(3), s1.charAt(1)};
        char[] c = s2.charAt(0) < s2.charAt(2) ? new char[]{s2.charAt(0), s2.charAt(2)} : new char[]{s2.charAt(2), s2.charAt(0)};
        char[] d = s2.charAt(1) < s2.charAt(3) ? new char[]{s2.charAt(1), s2.charAt(3)} : new char[]{s2.charAt(3), s2.charAt(1)};
        return (Arrays.equals(a, c) && Arrays.equals(b, d));
    }
}