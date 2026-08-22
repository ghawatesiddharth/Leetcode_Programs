class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] words = s.split(" ");
        if(n != words.length)return false;

        Map<Character,String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for(int i = 0;i < n;i++){
            char pchar = pattern.charAt(i);
            String word = words[i];

            if(map.containsKey(pchar)){
                if(!map.get(pchar).equals(word))return false;
            }            
            else{
                if(usedWords.contains(word))return false;

                map.put(pchar,word);
                usedWords.add(word);
            }
        }
        return true;
    }
}