class Solution {
    public String[] findWords(String[] words) {
        Set<Character> first =Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        Set<Character> second =Set.of('a','s','d','f','g','h','j','k','l');
        Set<Character> third =Set.of('z','x','c','v','b','n','m');
        List<String> word = new ArrayList<>();

        for(String w : words){
            StringBuilder firstCome = new StringBuilder();
            StringBuilder secondCome = new StringBuilder();
            StringBuilder thirdCome = new StringBuilder();

            String lower = w.toLowerCase();
            for(int i = 0; i < lower.length(); i++){
                char c = lower.charAt(i);
                if(first.contains(c)) firstCome.append(c);
                if(second.contains(c)) secondCome.append(c);
                if(third.contains(c)) thirdCome.append(c);
            }            
            if(lower.equals(firstCome.toString()) || lower.equals(secondCome.toString()) || lower.equals(thirdCome.toString())) word.add(w);
        }        
        String[] ans=  new String[word.size()];
        int i = 0;
        for(String cont : word){
            ans[i] = cont;
            i++;
        }
        return ans;

    }
}