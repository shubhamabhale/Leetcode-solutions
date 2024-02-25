class Solution {
        public boolean isOneEditDistance(String s, String t) {
        if (s.isEmpty()) {
            return t.length() == 1;
        }
        if (t.isEmpty()) {
            return s.length() == 1;
        }
        if (s.charAt(0) == t.charAt(0)) {
            return isOneEditDistance(s.substring(1), t.substring(1));
        } 
        return s.equals(t.substring(1)) || t.equals(s.substring(1)) || s.substring(1).equals(t.substring(1));
    }
}