class Solution {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i]; 
            }
            else if(nums[i] > second){
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third){
                third = nums[i];
            }

            if(nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            }
            else if(nums[i] < secondMin){
                secondMin = nums[i];
            }
        }
        int can1 = first*second*third;
        int can2 = first*firstMin*secondMin;
        return Math.max(can1,can2);
    }
}