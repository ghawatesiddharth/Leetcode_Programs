class Solution {
    public int minimumPushes(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c - 'a']++;
        }
        Arrays.sort(freq);

        int ans = 0;
        int rank = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            int count = (rank / 8) + 1;
            ans += freq[i] * count;
            rank++;
        }   
        return ans;
    }
}