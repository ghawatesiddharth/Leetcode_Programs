class Solution {
    public int maxProduct(int n) {
        if(n < 10)return n;
        List<Integer> list = new ArrayList<>();
        int temp = n, firstmax = 0, secondmax = 0;

        while(temp > 0){
            int rem = temp % 10;
            list.add(rem);
            temp /= 10;
        }
        for(int num : list){
            if(num > firstmax){
                secondmax = firstmax;
                firstmax = num;
            }
            else if(num > secondmax){
                secondmax = num;
            }
        }
        return firstmax * secondmax;
    }
}