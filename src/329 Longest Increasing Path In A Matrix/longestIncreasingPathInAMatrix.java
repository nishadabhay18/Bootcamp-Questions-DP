class longestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int best=Integer.MIN_VALUE;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                best=Math.max(best,helper(matrix ,i ,j, m-1, n-1, dp));
            }
        }
        return best;
    }
    public int helper(int[][] matrix, int sr,int sc,int er, int ec, int[][] dp){
        int m=matrix.length, n=matrix[0].length;
        int right=0, left=0, up=0, down=0;
        if(dp[sr][sc]!=0) return dp[sr][sc];
        if(sr<0 || sr>er || sc<0 || sc>ec) return 0;
        int ele=matrix[sr][sc];
        if(sc+1<=ec && ele< matrix[sr][sc+1]) right=helper(matrix, sr, sc+1, er, ec, dp);
        if(sc-1>=0 && ele< matrix[sr][sc-1]) left=helper(matrix, sr, sc-1, er, ec, dp);
        if(sr+1<=er && ele< matrix[sr+1][sc]) down=helper(matrix, sr+1, sc, er, ec, dp);
        if(sr-1>=0 && ele< matrix[sr-1][sc]) up=helper(matrix, sr-1, sc, er, ec, dp);
        return dp[sr][sc]=1+Math.max(Math.max(right,left),Math.max(up,down));
    }
}