class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows ; i++){
            List<Integer> currentRow = new ArrayList<>();
            for(int j = 0 ; j <= i; j++){
                if(j==0 || j==i){
                    currentRow.add(1);
                }
                else{
                    List<Integer> previousRow = result.get(i -  1);
                    currentRow.add(previousRow.get(j - 1) + previousRow.get(j)); 
                }
            }
            result.add(currentRow);
        }
        return result;
    }
}