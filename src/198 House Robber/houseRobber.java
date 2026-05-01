class houseRobber {
    // RECURSION
    public int rob(int[] arr) {
        return amount(arr, 0);
    }
    public int amount(int []arr, int idx){
        if(idx >= arr.length) return 0;
        int take = arr[idx] + amount(arr, idx+2);
        int skip = amount(arr, idx+1);
        int ans = Math.max(take, skip);
        return ans;
    }

    // RECURSION + MEMOIZATION
    public int rob(int[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        return amount(arr, 0, dp);
    }
    public int amount(int []arr, int idx, int[] dp){
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = arr[idx] + amount(arr, idx+2, dp);
        int skip = amount(arr, idx+1, dp);
        int ans = Math.max(take, skip);
        return dp[idx] = ans;
    }

    // TABULATION
    public int rob(int []arr){
        int n = arr.length;
        int dp[] = new int [n];
        if(n == 1) return arr[0];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i<n; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}
