class fibonacciNumber {
    // RECURSION TC-> O(2^n) SC-> O(n)
    public int fib(int n) {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
 
    // RECURSION + MEMOIZATION TC-> O(n) SC-> O(n)+O(n)
    static int []dp;
    public int fib(int n){
        int []dp = new int[n+1];
        return fibo(n, dp);
    }
    public int fibo(int n, int []dp){
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        int ans = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n] = ans;
    }

    // TABULATION TC-> O(n) SC-> O(1)
    public int fib(int n){
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
