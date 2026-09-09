class Solution {
    public long countCommas(long n) {
        if(n < 999)return 0;
        long ans = 0;
        long num = n - 999;
        if ( num > 0){
            ans+=num;
            num = n - 999999;
            if(num > 0){
                ans+=num;
                num = n - 999999999;
                if(num > 0){
                    ans+=num;
                    num=n-999999999999L;
                    if(num > 0){
                        ans+=num;
                        num=n-999999999999999L;
                        if( num >0){
                            ans+=num;
                        }
                    }
                }
            }
        }
        return ans;
    }
}