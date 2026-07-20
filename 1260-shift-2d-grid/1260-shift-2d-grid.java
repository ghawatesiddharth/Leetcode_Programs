class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        k %= (rows*cols);
        int[][] shifts = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int idex = i * cols + j;
                int newIdx = (idex + k) % (rows * cols);
                int newRow = newIdx / cols;
                int newCol = newIdx % cols;
                shifts[newRow][newCol] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] shift : shifts) {
            List<Integer> row = new ArrayList<>();

            for (int val : shift) {
                row.add(val);
            }

            ans.add(row);
            }
        return ans;
    }
}