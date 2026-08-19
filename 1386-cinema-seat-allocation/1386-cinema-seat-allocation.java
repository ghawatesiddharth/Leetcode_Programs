class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int i = 1,j = 1;
        for(int[] seat : reservedSeats){
            int row = seat[0];
            int seatNo = seat[1];
            if(!map.containsKey(row)){
                Set<Integer> seats = new HashSet<>();
                map.put(row,seats);
            }
            map.get(row).add(seatNo);
        }
        for(Map.Entry<Integer,Set<Integer>> entry : map.entrySet()){
            Set<Integer> reserved = entry.getValue();
            boolean left = false;
            if(!reserved.contains(2)&& !reserved.contains(3) && !reserved.contains(4)&&!reserved.contains(5)){
                left = true;
            }
            boolean right = false;
            if(!reserved.contains(6)&& !reserved.contains(7) && !reserved.contains(8)&&!reserved.contains(9)){
                right = true;
            }
            boolean middle = false;
            if(!reserved.contains(4)&& !reserved.contains(5) && !reserved.contains(6)&&!reserved.contains(7)){
                middle = true;
            }
            if(left && right) count+=2;
            else if(left || right || middle) count++;
        }
        count += (n - map.size()) * 2;
        return count;
    }
}