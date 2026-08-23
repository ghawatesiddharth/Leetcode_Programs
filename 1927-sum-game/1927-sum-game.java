class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        String left = "",right = "";
        for(int i =0 ;i < n/2; i++){
            left+=num.charAt(i);
            right+=num.charAt(n/2+i);
        }
        int leftsum = 0, rightsum = 0, leftq = 0, rightq = 0;     
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if(c=='?')leftq++;
            else leftsum += c - '0';
        }            
        for (int i = n/2; i < n; i++) {
            char c = num.charAt(i);
            if(c=='?')rightq++;
            else rightsum += c - '0';
        }         
        int diff = leftsum - rightsum;
        int diffq = (leftq - rightq);
        if (Math.abs(diffq) % 2 == 1) {
            return true;
        }
        return diff + 9 * diffq / 2 != 0;
    }
}