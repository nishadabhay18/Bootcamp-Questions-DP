class uniquePaths2 {
    // TABULATION
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=dp[i][j-1];
                else if(j==0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // RECURSION
    public int uniquePathsWithObstacles(int[][] grid){
        int m=grid.length, n=grid[0].length;
        return backtrack(grid,0,0,m-1,n-1);
    }
    public int backtrack(int[][] grid, int sr, int sc, int er, int ec){
        if(sr<0 || sc<0 || sr>er || sc>ec) return 0;
        if(grid[sr][sc]==-1 || grid[sr][sc]==1) return 0;
        if(sr==er && sc==ec){
            // count++;
            return 1;
        }
        grid[sr][sc]=-1;
        int ans1 =backtrack(grid,sr, sc+1, er, ec); // Right
        int ans2 =backtrack(grid,sr+1, sc, er, ec); // Down
        grid[sr][sc]=0;
        return ans1+ans2;
    }

    // RECURSION+MEMOIZATION
    public int uniquePathsWithObstacles(int[][] grid){
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) dp[i][j]=-1;
        return backtrack(grid,0,0,m-1,n-1,dp);
    }
    public int backtrack(int[][] grid, int sr, int sc, int er, int ec, int[][] dp){
        if(sr<0 || sc<0 || sr>er || sc>ec) return 0;
        if(grid[sr][sc]==-1 || grid[sr][sc]==1) return 0;
        if(sr==er && sc==ec){
            return 1;
        }
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        grid[sr][sc]=-1;
        int ans1 =backtrack(grid,sr, sc+1, er, ec, dp); // Right
        int ans2 =backtrack(grid,sr+1, sc, er, ec, dp); // Down
        grid[sr][sc]=0;
        return dp[sr][sc]=ans1+ans2;
    }
}