class Solution {
    public String stoneGameIII(int[] sv) {
        int n = sv.length;
        int[] dp = new int[n+1];
        int sum;
         
        for(int i = n - 1; i >=0;i--){
            int best = Integer.MIN_VALUE;
            sum = 0;
            for(int take = 1; take <=3;take++){
                if(i + take - 1 < n){
                    sum+= sv[i+take-1];
                    best = Math.max(best,sum-dp[i+take]);
                }
            }
            dp[i]=best;
        }
        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}