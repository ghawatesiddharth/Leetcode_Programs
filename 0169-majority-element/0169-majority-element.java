class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int max = Integer.MIN_VALUE,elem = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                elem = entry.getKey();
            }
        }
        return elem;
    }
}