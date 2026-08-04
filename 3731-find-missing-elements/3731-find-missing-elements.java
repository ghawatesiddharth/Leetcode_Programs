class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        int n = nums.length, start = nums[0],end = nums[n-1],i=0;

        if(n <2)return ans;

        while(start<end){
            if(i < n && nums[i]==start) {
                while(i < n && nums[i]==start){
                    i++;
                }
                start++;
                continue;
            }else {
                ans.add(start);
                start++;
            }
        }
        return ans;
    }
}