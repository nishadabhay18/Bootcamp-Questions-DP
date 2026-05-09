class deleteOperationForTwoStrings {
    // RECURSION+MEMOIZATION TC->O(m*n) SC->O(m*n)+O(m+n)
    public int minDistance(String word1, String word2) {
        int m=word1.length() , n=word2.length();
        int val=longestCommonSubsequence(word1,word2);
        return m-val+n-val;
    }
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
}