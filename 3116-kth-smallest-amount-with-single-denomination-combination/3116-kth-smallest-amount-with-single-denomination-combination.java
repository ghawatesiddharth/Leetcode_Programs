class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1,high = Long.MAX_VALUE;
        for(int n:coins){
            high = Math.min(high,n);
        }
        high *= k;

        while(low < high){
            long mid = low + (high - low) / 2;
            long count = countMultiple(coins,mid);
            if(count >=k)high = mid;
            else low=  mid+1;
        }
        return low;
    }
    public long countMultiple(int[] coins,long mid){
        long count = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = LCM(lcm, coins[i]);

                    if (lcm > mid) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                long multiples = mid / lcm;

                if (bits % 2 == 1)
                    count += multiples;
                else
                    count -= multiples;
            }
        }
        return count;
    }
    public long LCM(long a,long b){
        return (a/GCD(a,b))*b;
    }
    private long GCD(long a,long b){
        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}