class houseRobber2 {
    // RECURSION
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        int rob1=amount(arr,0,n-2);
        int rob2=amount(arr,1,n-1);
        return Math.max(rob1,rob2);
    }
    public int amount(int[]arr,int i,int j){
        int n=arr.length;
        if(i>j) return 0;
        int take=arr[i]+amount(arr,i+2,j);
        int skip=amount(arr,i+1,j);
        int ans=Math.max(take,skip);
        return ans;
    }

    // RECURSION + MEMOIZATION
    public int rob(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int rob1 = amount(arr, 0, n-2, dp1); // exclude last
        int rob2 = amount(arr, 1, n-1, dp2); // exclude first
        return Math.max(rob1,rob2);
    }
    public int amount(int[] arr, int i, int j, int[] dp) {
        if (i>j) return 0;
        if (dp[i]!=-1) return dp[i];
        int take= arr[i]+amount(arr, i+2, j, dp);
        int skip= amount(arr, i+1, j, dp);
        return dp[i] = Math.max(take,skip);
    }
}