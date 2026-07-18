class Solution {
    public int findGCD(int[] nums) {
        int ans = 0;
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for(int n : nums){
            mx = Math.max(mx,n);
            mn = Math.min(mn,n);
        }
        for(int i = 1; i <= mn; i++){
            if(mx % i == 0 && mn % i == 0) ans = i;
        }
        return ans;
    }
}