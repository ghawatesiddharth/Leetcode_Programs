class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        List<Integer> num = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(nums.length < 2) return ans;

        for(int i = 0;i < nums.length; i++){
            num.add(nums[i]);
        }
        for(int i = min+1;i < max; i++){
            if(!num.contains(i))ans.add(i);
        }
        return ans;
    }
}