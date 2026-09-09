class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left =0,maxlen = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) >= left){
                left = map.get(ch)+1;
            }
            map.put(ch,right);
            int curr = right - left+1;
            maxlen = Math.max(maxlen,curr);
        }
        return maxlen;
    }
}