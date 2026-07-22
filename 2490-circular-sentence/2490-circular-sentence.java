class Solution {
    public boolean isCircularSentence(String s) {
        boolean ans = false;
        int n = s.length();
        char start = s.charAt(0);
        char end = s.charAt(n-1);
        if(start!=end) return false;

        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(curr==' '){
                if(s.charAt(i - 1)!=s.charAt(i + 1))return false;
            } 
        }
        return true;       
    }
}