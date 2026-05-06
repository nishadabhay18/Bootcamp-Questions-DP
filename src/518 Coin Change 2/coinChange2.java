class Solution {
    // RECURSION TC-> O(2^n) SC-> O(n+amount)
    public int change(int amount, int[] coins) {
        return countWays(coins, amount, 0);
    }
    private int countWays(int[] coins, int amount, int idx) {
        if(idx >= coins.length){
            if(amount == 0) return 1;
            else return 0;
        }
        int skip=countWays(coins, amount, idx+1);
        int take = 0;
        if(amount-coins[idx] >= 0) take=countWays(coins, amount-coins[idx], idx);
        return skip + take;
    } 

    // RECURSION + MEMOIZATION TC-> O(n*amount) SC-> O(n*amount)+ O(n+amount) Stack Space
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer [][]dp = new Integer[n][amount+1];
        return countWays(coins, amount, 0, dp);
    }
    private int countWays(int[] coins, int amount, int idx, Integer[][]dp) {
        if(idx >= coins.length){
            if(amount == 0) return 1;
            else return 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int skip = countWays(coins, amount, idx+1, dp);
        int take = 0;
        if(amount-coins[idx] >= 0) take = countWays(coins, amount-coins[idx], idx, dp);
        return dp[idx][amount] = skip + take;
    }

    // TABULATION TC-> O(n*amount) SC-> O(n*amount)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        for(int j = 0; j<=amount; j++){
            if(j % coins[0] == 0) dp[0][j] = 1;
            else dp[0][j] = 0;
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=amount; j++){
                int skip = dp[i-1][j];
                int take = 0;
                if(j-coins[i] >= 0) take = dp[i][j-coins[i]];
                dp[i][j] = skip + take;
            }
        }
        return dp[n-1][amount];
    }

    // SPACE OPTIMIZATION TC-> O(n*amount) SC-> O(amount)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        for(int j = 0; j <= amount; j++){
            if(j % coins[0] == 0) prev[j] = 1;
            else prev[j] = 0;
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=amount; j++){
                int skip = prev[j];
                int take = 0;
                if(j-coins[i] >= 0) take = curr[j-coins[i]];
                curr[j] = skip + take;
            }
            prev = curr.clone();
        }
        return prev[amount];
    }
}
