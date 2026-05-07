class Solution {
    // RECURSION TC-> O(2^n) SC-> O(n)
     public int lengthOfLIS(int[] nums) {
         return helper(nums, 0, -1);
     }
     public int helper(int[] nums, int idx, int prev){
         int n = nums.length;
         if(idx == n) return 0;
         int len = 0 + helper(nums, idx+1, prev);
         if(prev == -1 || nums[idx]>nums[prev]) len = Math.max(len, 1 + helper(nums, idx+1, idx));
         return len;
     }

    // RECURSION + MEMOIZATION TC->O(n*n) SC->O(n*n)+O(n)
     public int lengthOfLIS(int[] nums) {
         int n = nums.length;
         Integer[][] dp = new Integer[n][n+1];
         return helper(nums, 0, -1, dp);
     }
     public int helper(int[] nums, int idx, int prev, Integer[][] dp){
         int n = nums.length;
         if(idx == n) return 0;
         if(dp[idx][prev+1] != null) return dp[idx][prev+1];
         int len = 0 + helper(nums, idx+1, prev, dp);
         if(prev == -1 || nums[idx]>nums[prev]) len = Math.max(len, 1 + helper(nums, idx+1, idx, dp));
         return dp[idx][prev+1] = len;
     }

    // TABULATON TC->O(n*n) SC->O(n*n)
     public int lengthOfLIS(int[] nums) {
         int n = nums.length;
         int [][] dp = new int[n+1][n+1];
         for(int idx = n-1; idx>=0; idx--){
             for(int prev = idx-1; prev>=-1; prev--){
                 int len = 0 + dp[idx+1][prev+1];
                 if(prev == -1 || nums[idx]>nums[prev]) len = Math.max(len, 1 + dp[idx+1][idx+1]);
                 dp[idx][prev+1] = len;
             }
         }
         return dp[0][-1+1];
     }

    // SPACE OPTIMIZATION TC->O(n*n) SC->O(1)
     public int lengthOfLIS(int[] nums) {
         int n=nums.length;
         int[] next = new int[n+1];
         int[] curr = new int[n+1];
         for(int idx = n-1; idx>=0; idx--){
             for(int prev = idx-1; prev>=-1; prev--){
                 int len = 0 + next[prev+1];
                 if(prev == -1 || nums[idx]>nums[prev]) len = Math.max(len, 1 + next[idx+1]);
                 curr[prev+1] = len;
             }
             next = curr.clone();
         }
         return curr[-1+1];
     }

    // Thinking of Tabulation without recursion TC->O(n*n) SC->O(1) Method 1
     public int lengthOfLIS(int[] nums){
         int n = nums.length;
         int[] dp = new int[n];
         int maxLen = 0;
         for(int i = 0; i<n; i++){
             for(int j = 0; j<=i-1; j++){
                 if(nums[j]<nums[i]) dp[i] = Math.max(dp[i], dp[j]);
             }
             dp[i] += 1;
             maxLen = Math.max(maxLen, dp[i]);
         }
         return maxLen;
     }

    // Thinking of Tabulation without recursion TC->O(n*n) SC->O(1) Method 2
     public int lengthOfLIS(int[] nums){
         int n = nums.length;
         int[] dp = new int[n];
         int maxLen = 0;
         for(int i = 0; i<n; i++){
             for(int j = 0; j<i; j++){
                 if(nums[j]<nums[i] && dp[j] + 1>dp[i]) dp[i] = dp[j]+1;
             }
             maxLen=Math.max(maxLen, dp[i]);
         }
         return maxLen;
     }

    // Now using Binary Search TC->O(n*log(n)) SC->O(n)
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i<n; i++){
            if(nums[i]>list.get(list.size()-1)) list.add(nums[i]);
            else list.set(lowerBound(list, nums[i]), nums[i]);
        }
        return list.size();
    }
    public int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size()-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(list.get(mid) >= target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}