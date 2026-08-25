class Solution {
    public boolean rotateString(String s, String goal) {
        String con = s + s;
        if(s.length() != goal.length())return false;
        return con.contains(goal);
    }
}