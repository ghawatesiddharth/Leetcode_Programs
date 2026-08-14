class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0,ans = Integer.MIN_VALUE;
        int[] freq = new int[26];
        for(int right = 0;right < s.length(); right++){
            int idx = s.charAt(right) - 'a';
            freq[idx]++;
            while(freq[idx] > 2){
                int lefidx = s.charAt(left) - 'a';
                freq[lefidx]--;
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}