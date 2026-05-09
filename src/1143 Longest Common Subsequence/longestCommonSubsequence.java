class longestCommonSubsequence {
    // RECURSION TC-> O(2^(m+n)) SC-> O(m+n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        return helper(text1, text2, m-1, n-1);
    }
    public int helper(String text1, String text2, int idx1, int idx2){
        int m=text1.length(), n=text2.length();
        if(idx1<0 || idx2<0) return 0;
        if(text1.charAt(idx1)==text2.charAt(idx2)) return 1+helper(text1, text2, idx1-1, idx2-1);
        return Math.max(helper(text1, text2, idx1-1, idx2), helper(text1, text2, idx1, idx2-1));
    }

    // RECURSION+MEMOIZATION TC-> O(m*n) SC-> O(m*n)+O(m+n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        Integer[][] dp=new Integer[m][n];
        return helper(text1, text2, m-1, n-1, dp);
    }
    public int helper(String text1, String text2, int idx1, int idx2, Integer[][] dp){
        int m=text1.length(), n=text2.length();
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];
        if(text1.charAt(idx1)==text2.charAt(idx2)) return dp[idx1][idx2]=1+helper(text1, text2, idx1-1, idx2-1, dp);
        return dp[idx1][idx2]= Math.max(helper(text1, text2, idx1-1, idx2, dp), helper(text1, text2, idx1, idx2-1, dp));
    }

    // TABULATION TC-> O(m*n) SC-> O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0]=0;
        for(int j=0;j<=n;j++) dp[0][j]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    // SPACE OPTIMIZATION TC-> O(m*n) SC-> O(m)
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int j=0;j<=n;j++) prev[j]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) curr[j]=1+prev[j-1];
                else curr[j]=Math.max(prev[j],curr[j-1]);
            }
        }
        return prev[n];
    }
}