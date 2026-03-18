class uniquePaths {
    //RECURSION
    public int uniquePaths(int m, int n) {
        return paths(0,0,m-1,n-1);
    }
    public int paths(int sr,int sc, int er, int ec){
        if(sr>er || sc>ec) return 0;
        if(sr==er && sc==ec) return 1;
        return paths(sr,sc+1,er,ec)+paths(sr+1,sc,er,ec);
    }

    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1;
        return paths(0,0,m-1,n-1,dp);
    }
    public int paths(int sr,int sc, int er, int ec, int[][]dp){
        if(sr>er || sc>ec) return 0;
        if(sr==er && sc==ec) return 1;
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        return dp[sr][sc]=paths(sr,sc+1,er,ec,dp)+paths(sr+1,sc,er,ec,dp);
    }

    // //TABULATION
    public int uniquePaths(int m,int n){
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 ||j==0) dp[i][j]=1;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // SPACE OPTIMIZATION
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[2][n];
        for(int j=0;j<n;j++){
            dp[0][j]=1;
            dp[1][j]=1;
        }
        for(int i=1;i<=m-1;i++){
            for(int j=1;j<n;j++){
                dp[1][j]=dp[1][j-1]+dp[0][j];
            }
            for(int j=1;j<n;j++){
                dp[0][j]=dp[1][j];
            }
        }
        return dp[1][n-1];
    }
}