class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int ans = Integer.MAX_VALUE, bestPrev = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        int[] best = new int[arr.length];
        Arrays.fill(best,Integer.MAX_VALUE);
        for(int right = 0; right < arr.length; right++){
            sum+=arr[right];
            while(sum > target){
                sum-=arr[left];
                left++;
            }
            if(right>0)best[right] = best[right - 1];
            if(sum==target){
                int currLen = right - left + 1;
                if(left > 0 && best[left - 1] != Integer.MAX_VALUE){
                    int cand =best[left - 1]+currLen;
                    ans = Math.min(ans,cand);
                }
                best[right] = Math.min(best[right],currLen);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}