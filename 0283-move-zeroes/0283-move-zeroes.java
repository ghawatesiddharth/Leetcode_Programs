class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> num= new ArrayList<>();
        for(int n : nums){
            if(n !=0)num.add(n);
        }
        int zero =(nums.length > num.size())? nums.length - num.size():0;
        for(int i = 0;i < zero;i++){
            num.add(0);
        }
        for (int i = 0; i < num.size(); i++) {
            nums[i] = num.get(i);
        }
        for(int i = 0;i < num.size();i++){
            System.out.print(nums[i]);
        }
    }
}