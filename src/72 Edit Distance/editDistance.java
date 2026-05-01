class editDistance {
    // RECURSION
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length(), n = b.length();
        return minSteps(m-1, n-1, a, b);
    }
    public int minSteps(int i, int j, StringBuilder a, StringBuilder b){
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;
        int del, rep, ins;
        if(a.charAt(i) == b.charAt(j)) return minSteps(i-1, j-1, a, b);
        else{
            del = minSteps(i-1, j, a, b);
            rep = minSteps(i-1, j-1, a, b);
            ins = minSteps(i, j-1, a, b);
        }
        return 1 + Math.min(del, Math.min(ins, rep));
    }

    // RECURSION + MEMOIZATION
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i= 0; i<=m; i++)
            for(int j = 0; j<=n; j++) dp[i][j] = -1;
        return minSteps(m-1, n-1, a, b, dp);
    }
    public int minSteps(int i, int j, StringBuilder a, StringBuilder b, int[][] dp){
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;
        int del, rep, ins;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = minSteps(i-1, j-1, a, b, dp);
        else{
            del = minSteps(i-1, j, a, b, dp);
            rep = minSteps(i-1, j-1, a, b, dp);
            ins = minSteps(i, j-1, a, b, dp);
        }
        return dp[i][j] = 1 + Math.min(del, Math.min(ins, rep));
    }
}
