class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int[] ans = new int[s.length()];
        int depth = 0,i=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                depth++;
                if(depth %2==0){
                    ans[i]=1;
                }
                else{
                    ans[i]=0;
                }
            }
            else{
                if(depth %2==0){
                    ans[i]=1;
                }
                else{
                    ans[i]=0;
                }
                depth--;
            }
            i++;
        }
        return ans;
    }
}