class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp,false);
        dp[n-1]=true;
        for(int i = n-2;i >= 0;i--){
            int maxreach = Math.min(nums[i]+i,n-1);
            for(int j = i+1;j <= maxreach;j++){
                if(dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}