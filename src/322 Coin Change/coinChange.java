class Solution {
    // RECURSION TC-> O(2^n) SC-> O(n+amount)
    public int coinChange(int[] coins, int amount) {
        int ans = (int)coinCount(coins, amount, 0);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public long coinCount(int []coins, int amount, int idx){
        if(idx == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        long skip = coinCount(coins, amount, idx+1);
        if(amount-coins[idx] < 0) return skip;
        long take = 1 + coinCount(coins, amount-coins[idx], idx);
        return Math.min(take, skip);
    }

    // RECURSION + MEMOIZATION with long datatype
     public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long [][]dp = new long [n][amount+1];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<=amount; j++) dp[i][j]=-1;
        int ans = (int)coinCount(coins, amount, 0, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public long coinCount(int []coins, int amount, int idx, long[][]dp){
        if(idx == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        long skip = coinCount(coins, amount, idx+1, dp);
        if(amount-coins[idx]<0) return dp[idx][amount] = skip;
        long take = 1 + coinCount(coins, amount-coins[idx], idx, dp);
        return dp[idx][amount] = Math.min(take, skip);
    }

    // RECURSION + MEMOIZATION with wrapper class or 1e9 TC-> O(n*amount) SC-> O(n*amount) + O(n+amount) Stack Space
    public int coinChange(int[] coins, int amount){
        Integer[][] dp = new Integer[coins.length][amount+1];
        int ans = (int)helper(coins, amount, 0, dp);
        return ans == (int)1e9 ? -1:ans;
    }
    public int helper(int[] coins, int amount, int idx, Integer[][] dp){
        int n = coins.length;
        if(idx == n){
            if(amount == 0) return 0;
            else return (int)1e9;
        }
        if(dp[idx][amount] != null) return dp[idx][amount];
        int skip = helper(coins, amount, idx+1, dp);
        if(amount-coins[idx]<0) return dp[idx][amount] = skip;
        int take = 1 + helper(coins, amount-coins[idx], idx, dp);
        return dp[idx][amount] = Math.min(take, skip);
    } 

    // TABULATION TC-> O(n*amount) SC-> O(n*amount)
    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        for(int j = 0; j<=amount; j++){
            if(j % coins[0] == 0) dp[0][j] = j/coins[0];
            else dp[0][j] = (int)1e9;
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=amount; j++){
                int skip = dp[i-1][j]; 
                if(j-coins[i]<0){
                    dp[i][j] = skip; 
                    continue;
                }
                int take = 1 + dp[i][j-coins[i]];
                dp[i][j] = Math.min(take, skip);
            }
        }
        int ans = dp[n-1][amount];
        return ans = (dp[n-1][amount] == (int)1e9) ? -1 : ans;
    }

    // SPACE OPTIMIZATION TC-> O(n*amount) SC-> O(n*amount)
    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        for(int j = 0; j<=amount; j++){
            if(j % coins[0] == 0) prev[j] = j/coins[0];
            else prev[j] = (int)1e9;
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=amount; j++){
                int skip = prev[j]; 
                if(j-coins[i] < 0){
                    curr[j] = skip; 
                    continue;
                }
                int take = 1 + curr[j-coins[i]];
                curr[j] = Math.min(take, skip);
            }
            prev = curr.clone();
        }
        int ans = prev[amount];
        return ans = (prev[amount] == (int)1e9) ? -1 : ans;
    }
}
