class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length, m = grid[0].length;
        int total = n*n, expsum = total * (total + 1)/2;
        int dup = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(set.contains(grid[i][j]))dup = grid[i][j];
                else set.add(grid[i][j]);
                sum+=grid[i][j];
            }
        }
        expsum = expsum - sum + dup;
        ans[0]=dup;
        ans[1]=expsum;
        return ans;
    }
}