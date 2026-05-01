class fibonacciNumber {
    public static int fibRec(int n) {
        if(n <= 1) return n;
        return fibRec(n-1) + fibRec(n-2);
    }

    static int []dp;
    public static int fibMemo(int n){
        int []dp = new int[n+1];
        return fibo(n, dp);
    }
    public static int fibo(int n, int []dp){
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        int ans = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n] = ans;
    }

    public static int fibTab(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int []dp = new int[3];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[2] = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
