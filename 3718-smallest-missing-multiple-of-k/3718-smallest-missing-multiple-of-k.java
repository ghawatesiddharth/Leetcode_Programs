class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, multiple = k;
        for(int num : nums){
            if(num==multiple) multiple = multiple + k;
            else if (num > multiple)return multiple;
        }
        return multiple;
    }
}