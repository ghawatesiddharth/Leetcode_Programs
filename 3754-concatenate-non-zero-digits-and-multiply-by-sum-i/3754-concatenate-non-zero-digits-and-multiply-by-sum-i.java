class Solution {
    public long sumAndMultiply(int n) {
        String seq =Integer.toString(n);
        int sum = 0;
        int val = 0;
        int ori = n;
        int mul = 1;
        while(ori > 0){
            int digit = ori % 10;
            sum += digit;
            if(digit!=0){
                 val += digit * mul;
                mul*=10;
            }
            ori/=10;
        }
        return (long)val*sum;
    }
}