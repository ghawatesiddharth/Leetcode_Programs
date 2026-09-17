class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        for(int i = 0;i < strs[0].length();i++){
            String first = strs[0];
            String last = strs[strs.length - 1];
            if(first.charAt(i)==last.charAt(i))sb.append(first.charAt(i));
            else{
                break;
            }
        }
        return sb.toString();
    }
}