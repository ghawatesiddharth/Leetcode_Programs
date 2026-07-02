class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int row = grid.size();
        int col = grid.get(0).size();
        int[][] dist = new int[row][col];

        for (int[] rows : dist)
            Arrays.fill(rows, Integer.MAX_VALUE);

        dist[0][0] = grid.get(0).get(0);

        Deque<int[]> dq = new LinkedList<>();
        int dmg = grid.get(0).get(0);
        dq.offerFirst(new int[]{0,0});

        while(!dq.isEmpty()){
            int[] cell = dq.pollFirst();
            int r = cell[0];
            int c = cell[1];
            int newDmg = 0;
            //directions
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col ) {
                    newDmg = dist[r][c] + grid.get(nr).get(nc);
                    if(newDmg < dist[nr][nc]){
                        dist[nr][nc]=newDmg;
                        if(grid.get(nr).get(nc)==0){
                            dq.offerFirst(new int[]{nr,nc});
                        }
                    
                    else{
                        dq.offerLast(new int[]{nr,nc});
                    }
                }
                }

            }
        }
        return dist[row-1][col-1] < health;
    }
}