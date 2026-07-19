class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0; i < 26; i++){
            visited[i] = false;
        }

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : s.toCharArray()){            
            freq[c - 'a']--;
            if(visited[c - 'a']) continue;

            while(!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0){
                char ch = stack.pop();
                visited[ch - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();

        for(char ch : stack){
            ans.append(ch);
        }
        return ans.toString();
    }
}