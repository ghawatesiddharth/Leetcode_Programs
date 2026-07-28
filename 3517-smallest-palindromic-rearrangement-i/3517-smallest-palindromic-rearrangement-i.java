class Solution {
    public String smallestPalindrome(String s) {
        if(s==null ||s.length()==1 ) return s;
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a'] ++;
        }
        StringBuilder left = new StringBuilder();
        String middle = "";
        for(char c = 'a' ; c <='z' ; c++){
            for(int i = 0;i < freq[c - 'a']/2; i++){
                left.append(c);
            }
            if(freq[c - 'a'] % 2 == 1){
                middle = String.valueOf(c);
            }
        }
        String right = reverse(left.toString());
        return left+middle+right;
    }
    public String reverse(String left){
        String right = "";
        for(int i = left.length() - 1; i >= 0; i--){
            right+= left.charAt(i);
        }
        return right;
    }
}