class Solution {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        
        for(int i = 0 ;i < nums.length; i++){
            if(first < nums[i]){
                third = second;
                second = first;
                first = nums[i];
            }
            else if(second < nums[i]){
                third = second;
                second = nums[i];
            }
            else if (third < nums[i]){
                third = nums[i];
            }
            if(firstMin > nums[i]){
                secondMin = firstMin;
                firstMin = nums[i];
            }
            else if(secondMin > nums[i]){
                secondMin = nums[i];
            }
        }
        int ans1 = firstMin * secondMin;
        ans1*=first;
        int ans2 = first * second *  third;

        return Math.max(ans1,ans2);
    }
}