class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = s.length();
        int pchar = 0;
        Map<Character,String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            while(i < n && s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                i++;
            }
            String word = sb.toString();
            if(pchar >= pattern.length()) return false;
            char ch = pattern.charAt(pchar++);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word)) return false;
            }
            else{
                if(usedWords.contains(word)) return false;
                map.put(ch, word);
                usedWords.add(word);
            }
        }
        return pchar == pattern.length();
    }
}