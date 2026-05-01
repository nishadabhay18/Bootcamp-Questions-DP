class coinChange2 {
    // RECURSION
    public int change(int amount, int[] coins) {
        return countWays(coins, amount, 0);
    }
    private int countWays(int[] coins, int amount, int idx) {
        if (amount == 0) return 1;
        if (idx == coins.length) return 0;
        int skip = countWays(coins, amount, idx + 1);
        int take = 0;
        if (amount - coins[idx] >= 0) take = countWays(coins, amount - coins[idx], idx);
        return skip + take;
    }

    // RECURSION+MEMOIZATION
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int [n][amount+1];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<=amount; j++) dp[i][j] = -1;
        return countWays(coins, amount, 0, dp);
    }
    private int countWays(int[] coins, int amount, int idx, int[][]dp) {
        if (amount == 0) return 1;
        if (idx == coins.length) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int skip = countWays(coins, amount, idx + 1,dp);
        int take = 0;
        if (amount - coins[idx] >= 0) take = countWays(coins, amount - coins[idx], idx, dp);
        return dp[idx][amount] = skip + take;
    }
}
