class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0, n = s.length() - 1;
        while(n >= 0 && s.charAt(n)==' ') {
            n--;
        }
        while(n>=0 && s.charAt(n)!=' '){
            ans++;
            n--;
        }
        return ans;
    }
}