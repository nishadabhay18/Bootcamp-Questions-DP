class minimumInsertionsToMakeAStringPalindrome {
    // RECURSION + MEMOIZATION TC-> O(n*n) SC-> O(n*n)+O(n)
    // public int minInsertions(String s) {
    //     int n=s.length();
    //     return n-longestPalindromeSubseq(s);
    // }
    // public int longestPalindromeSubseq(String s) {
    //     StringBuilder a=new StringBuilder(s);
    //     return longestCommonSubsequence(s, a.reverse().toString());
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m=text1.length(), n=text2.length();
    //     Integer [][]dp=new Integer[m][n];
    //     return lcs(m-1,n-1,text1,text2,dp);
    // }
    // public int lcs(int i, int j,String text1,String text2,Integer [][]dp){
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(text1.charAt(i)==text2.charAt(j)) return dp[i][j]=1+lcs(i-1,j-1,text1,text2,dp);
    //     else return dp[i][j]= Math.max(lcs(i-1,j,text1,text2,dp),lcs(i,j-1,text1,text2,dp));
    // }

    // TABULATION TC-> O(n*n) SC-> O(n*n)
    // public int minInsertions(String s) {
    //     return s.length()-longestPalindromeSubseq(s);
    // }
    // public int longestPalindromeSubseq(String s) {
    //     StringBuilder a=new StringBuilder(s);
    //     return longestCommonSubsequence(s, a.reverse().toString());
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m=text1.length(), n=text2.length();
    //     int [][]dp=new int[m+1][n+1];
    //     for(int i=1;i<=m;i++){
    //         for(int j=1;j<=n;j++){
    //             if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
    //             else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
    //         }
    //     }
    //     return dp[m][n];
    // }

    // SPACE OPTIMIZATION TC-> O(n*n) SC-> O(n*n)
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder a=new StringBuilder(s);
        return longestCommonSubsequence(s, a.reverse().toString());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) curr[j]=1+prev[j-1];
                else curr[j]= Math.max(prev[j],curr[j-1]);
            }
            prev=curr.clone();
        }
        return prev[n];
    }
}