class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j <= i; j++) max = Math.max(max,nums[j]);

            for(int j = i; j < n; j++) min = Math.min(min,nums[j]);

            if(max - min <= k)return i;
        }
        return -1;
    }
}