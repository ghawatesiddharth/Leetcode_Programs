class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        int max = -1;

        if(k==1){
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(entry.getValue()==1)max = Math.max(max,entry.getKey());
            }
        }

        else if(k==nums.length){
            for(int n : nums){
                max = Math.max(max,n);
            }
        }

        else{
            int freq1 = map.get(nums[0]);
            int freq2 = map.get(nums[nums.length - 1]);

            if(freq1 == 1 && freq2 == 1)max = Math.max(nums[0],nums[nums.length - 1]);

            else if(freq1==1)return nums[0];

            else if(freq2==1)return nums[nums.length - 1];
        }
        return max;
    }
}