class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        //if(nums[0]%k!=0)ans = nums[0];

        for(int i =0;i < n;i++){
            if(set.contains(cnt*k)) cnt+=1;
        }
        return cnt * k;
    }
}