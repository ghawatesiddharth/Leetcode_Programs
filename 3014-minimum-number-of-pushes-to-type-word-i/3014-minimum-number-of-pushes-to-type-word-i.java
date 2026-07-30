class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int ans = 0;
        for(int i = 0; i <  len; i++){
            int val = (i / 8) + 1;
            ans+=val;
        }
        return ans;
    }
}