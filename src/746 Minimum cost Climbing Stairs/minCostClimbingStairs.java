class minCostClimbingStairs {
    // RECURSION
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }
    public int minCost(int[] cost, int idx){
        if(idx == 1 || idx == 0) return cost[idx];
        return cost[idx] + Math.min(minCost(cost, idx-1), minCost(cost, idx-2));
    }

    // RECURSION + MEMOIZATION
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []dp = new int[n]; // idx is going from n-1 to 0
        Arrays.fill(dp, -1);
        return Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    }
    public int minCost(int[] cost, int idx, int[] dp){
        if(idx == 1 || idx == 0) return cost[idx];
        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(minCost(cost, idx-1, dp), minCost(cost, idx-2, dp));
    }

    // TABULATION
    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]);
        }
        return Math.min(dp[n-2], dp[n-1]);
    }
}
