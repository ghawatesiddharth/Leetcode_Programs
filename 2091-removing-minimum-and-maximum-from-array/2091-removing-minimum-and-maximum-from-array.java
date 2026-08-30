class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int[] position = new int[n];
        int min = Integer.MAX_VALUE, minIdx = 0;
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for(int i = 0;i < nums.length; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        for(int i = 0;i < nums.length; i++){
            if(min==nums[i]) minIdx = i;
            if(max==nums[i]) maxIdx = i;
        }
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);
        int ans1 = (left + 1) + (n - right);
        int ans2 = right + 1;
        int ans3 = n - left;
        int ans = Math.min(ans1,ans2);
        ans = Math.min(ans,ans3);
        return ans;
    }
}