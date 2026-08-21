class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }    
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==1)ans = entry.getKey();
        }
        return ans;
    }
}