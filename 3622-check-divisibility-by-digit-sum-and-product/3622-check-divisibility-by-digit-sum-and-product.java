class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1,ori= n;
        while(n>0){
            sum+= n%10;
            product*=n%10;
            n/=10;
        }
        return (ori % (sum+product))== 0;
    }
}