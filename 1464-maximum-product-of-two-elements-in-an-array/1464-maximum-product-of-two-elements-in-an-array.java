class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for(int n : nums){
            if(n > max1){
                max2 = max1;
                max1 = n;
            }
            else if(n > max2){
                max2 = n;
            }
        }
        return (max1-1) * (max2-1);
    }
}