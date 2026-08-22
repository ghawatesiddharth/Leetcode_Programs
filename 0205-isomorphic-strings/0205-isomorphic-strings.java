class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { 
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            if (!smap.getOrDefault(charS, 0).equals(tmap.getOrDefault(charT, 0))) {
                return false; 
            }
            smap.put(charS, i + 1); 
            tmap.put(charT, i + 1); 
        } 
        return true;
    }
}