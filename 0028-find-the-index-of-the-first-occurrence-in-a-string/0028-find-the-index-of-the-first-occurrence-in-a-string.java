class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle))return -1;
        String[] arr = haystack.split(needle,-1);
        return arr[0].length();
    }
}