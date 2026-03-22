class targetSum {
    // RECURSION
     public int findTargetSumWays(int[] nums, int target) {
         int n=nums.length;
         return ways(nums,target,0);
     }
     public int ways(int[]nums,int target,int idx){
         if(idx==nums.length){
             if(target==0) return 1;
             else return 0;
         }
         int add=ways(nums,target-nums[idx],idx+1);
         int sub=ways(nums,target+nums[idx],idx+1);
         return add+sub;
     }

     // RECURSION+MEMOIZATION
    static int sum;
    public int ways(int[]nums,int target,int res,int idx,int[][]dp){
        if(idx==nums.length){
            if(res==target) return 1;
            else return 0;
        }
        if(dp[idx][res+sum]!=-1) return dp[idx][res+sum];
        int add=ways(nums,target,res+nums[idx],idx+1,dp);
        int sub=ways(nums,target,res-nums[idx],idx+1,dp);
        return dp[idx][res+sum]= add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        sum=0;
        // idx-0 to n | target- -sum to sum
        for(int i=0;i<n;i++) sum+=nums[i];
        int [][]dp=new int [n][2*sum+1];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        return ways(nums,target,0,0,dp);
    }
}