class Solution {
    public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] preval = intervals[0];
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 1 ;i < intervals.length; i++){
            int[] curval = intervals[i];
            if(preval[1] >= curval[0]) preval[1] = Math.max(preval[1],curval[1]); 

            else {
                list.add(preval);
                preval = curval;
            }        
        }
        list.add(preval);

        int[][]ans = new int[list.size()][];
        for(int i = 0;i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;

    }
}