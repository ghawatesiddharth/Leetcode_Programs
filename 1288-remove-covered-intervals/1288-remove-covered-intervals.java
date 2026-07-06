class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b)->{ 
        if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
        return Integer.compare(a[0],b[0]);
        });
        int maxVal = 0;
        for(int[] interval : intervals){
            if(interval[1] > maxVal) {
                count++; 
                maxVal = interval[1];
            }     
        }
        return count;
    }
}