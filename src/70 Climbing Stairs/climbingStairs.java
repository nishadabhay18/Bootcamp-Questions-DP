class climbingStairs {
    // RECURSION
    public int climbStairs(int n){
        if(n==0 || n==1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs(int n){
        if(n==0 ||n==1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    // RECURSION + MEMOIZATION
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsWays(n, dp);
    }
    public int climbStairsWays(int n, int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = climbStairsWays(n-1, dp) + climbStairsWays(n-2, dp);
    }
}
