class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length,j = 0;
        int[] nums2 = new int[n];
        int min = Integer.MAX_VALUE;
        int even = 0,odd = 0;
        
        for(int num : nums1){
            min = Math.min(min,num);
        }

        if(min % 2==0){
            for(int i = 0;i < nums1.length; i++){
                if(nums1[i] %2!=0)odd++;
                else even++;
            }
            if(even==nums1.length)return true;
            else return false;
        }
        return true;
    }
}