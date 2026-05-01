class partitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        // target- target to 0 | idx- 0 to n
        int [][]dp = new int [n][target+1];
        for(int i = 0; i<n; i++)
            for(int j = 0; j <= target; j++) dp[i][j]=-1;
        return subsetSum(nums, target, 0, dp);
    }
    public boolean subsetSum(int []arr, int target, int idx, int[][]dp){
        if(idx == arr.length){
            return (target==0);
        }
        if(dp[idx][target] != -1) return (dp[idx][target] == 1);
        boolean ans = false;
        boolean skip = subsetSum(arr, target, idx+1, dp);
        if(target - arr[idx] < 0) ans= skip;
        else{
            boolean take = subsetSum(arr, target - arr[idx], idx+1, dp);
            ans = take || skip;
        }
        if (ans) dp[idx][target] = 1;
        else dp[idx][target] = 0;
        return ans;
    }
}
