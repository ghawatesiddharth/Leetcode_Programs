class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[][] values = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            values[i][0]=entry.getKey();
            values[i][1]=entry.getValue();
            i++;
        }
        Arrays.sort(values, (a, b) -> { if (a[1] == b[1]) {
                return Integer.compare(b[0], a[0]); 
            }
            return Integer.compare(a[1], b[1]);     
        });
        int[] ans = new int[nums.length];
        int ansIdx = 0;
        for (int[] val : values) {
            int element = val[0];
            int frequency = val[1];
            for (int k = 0; k < frequency; k++) {
                ans[ansIdx++] = element;
            }
        }
        
        return ans;
    }
}