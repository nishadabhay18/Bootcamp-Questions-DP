class nthTribonacciNumber {
    //RECURSION
    public static int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // RECURSION+MEMOIZATION
    public static int tribonacci(int n){
        int []dp = new int [n+1];
        return tribo(n, dp);
    }
    public static int tribo(int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(dp[n] != 0) return dp[n];
        int ans = tribo(n-1, dp) + tribo(n-2, dp) + tribo(n-3, dp);
        return dp[n] = ans;
    }

    // Tabulation
    public static int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int[] dp = new int[4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            dp[3] = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}
