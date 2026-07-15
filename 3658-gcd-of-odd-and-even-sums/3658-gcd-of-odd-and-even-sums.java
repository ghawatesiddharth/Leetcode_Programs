class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = n * (2 * 1 + (n - 1) * 2) / 2;
        int evenSum = n * (2 * 2 + (n - 1) * 2) / 2;
        return gcd(oddSum,evenSum);
    }
    public int gcd(int a, int b){
    while(b != 0){
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
    }
}
